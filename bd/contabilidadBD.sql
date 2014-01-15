-- Base de datos que usa el Software Contable hecho en java 1.7

create database contabilidad;
use contabilidad;

-- creacion de tablas

create table if not exists empresas
(

id_empresa int not null auto_increment,
nombre varchar(50),
descripcion varchar(50),
fecha_creacion timestamp,

primary key(id_empresa)

);

create table if not exists catalogo_de_cuentas
(

id_catalogo int not null auto_increment,
nombre varchar(50),
id_empresa int,
fecha_creacion timestamp,

primary key(id_catalogo),
foreign key(id_empresa) references empresas(id_empresa)

);

create table if not exists cuentas
(

id_cuenta int not null auto_increment,
nombre varchar(50),
codigo varchar(15),
descripcion varchar(50),
saldo_deudor double,
saldo_acreedor double,
fecha_creacion timestamp,
id_catalogo int,

primary key(id_cuenta),
foreign key(id_catalogo) references catalogo_de_cuentas(id_catalogo)

);

create table if not exists sub_cuentas
(

id_subcuenta int not null auto_increment,
nombre varchar(50),
codigo varchar(15),
descripcion varchar(50),
saldo_deudor double,
saldo_acreedor double,
fecha_creacion timestamp,
id_cuenta int,
id_catalogo int,

primary key(id_subcuenta),
foreign key(id_cuenta) references cuentas(id_cuenta)

);

create table if not exists conceptos
(

id_concepto int not null auto_increment,
nombre varchar(50),
codigo varchar(15),
descripcion varchar(50),
debe double,
haber double,
fecha_creacion timestamp,
saldo_deudor double,
saldo_acreedor double,
id_subcuenta int,
id_catalogo int,

primary key(id_concepto),
foreign key(id_subcuenta) references sub_cuentas(id_subcuenta)

);

create table if not exists sub_conceptos
(

id_subconcepto int not null auto_increment,
nombre varchar(50),
codigo varchar(15),
descripcion varchar(50),
debe double,
haber double,
fecha_creacion timestamp,
saldo_deudor double,
saldo_acreedor double,
id_concepto int,
id_catalogo int, 

primary key(id_subconcepto),
foreign key(id_concepto) references conceptos(id_concepto)

);

create table if not exists diario
(

id_diario int not null auto_increment,
num_operacion int,
fecha timestamp,
concepto varchar(50),
saldo double,
tipo_operacion varchar(15),
id_catalogo int,

primary key(id_diario),
foreign key(id_catalogo) references catalogo_de_cuentas (id_catalogo)

);

create table if not exists diario_subconceptos
(

id_diarios int not null auto_increment,
sub_concepto varchar(50),
saldo double,
tipo_operacion varchar(15),
nombre_concepto varchar(50),
num_operacion int,
id_catalogo int,
fecha timestamp,

primary key(id_diarios),
foreign key(id_catalogo) references catalogo_de_cuentas (id_catalogo)

);

create table if not exists articulos
(

id_articulo int not null auto_increment,
nombre varchar(50),
existencia int,
precio_costo double,
total double,
id_subconcepto int,
lote int,

primary key ( id_articulo ),
foreign key (id_subconcepto) references sub_conceptos (id_subconcepto)

);

create table if not exists balance_inicial
(

id_balance int not null auto_increment,
total_activos double,
total_pasivos double,
capital_contable double,
id_catalogo int,

primary key ( id_balance ),
foreign key( id_catalogo ) references catalogo_de_cuentas( id_catalogo )
);


-- procedimientos almacenados

delimiter $$

create procedure guardar_balance_inicial
(
in capital_contablei double,
in id_catalogoi int,
out ban int
)
begin
declare total_activosi double;
declare total_pasivosi double;

call obtener_saldo_activo(id_catalogoi,@ban);
set total_activosi = ( select @ban  );

call obtener_saldo_pasivo(id_catalogoi,@ban);
set total_pasivosi = ( select @ban  );

insert into balance_inicial( total_activos, total_pasivos, capital_contable, id_catalogo )
values( total_activosi, total_pasivosi, capital_contablei, id_catalogoi );

set ban = 1; -- OK!

end$$

create procedure inserta_articulosv
(
in nombrei varchar(50),
in existenciai int,
in precio_costoi double,
in totali double,
in id_subconceptoi int,
in lotei int,
out ban int
)
begin

insert into articulos( nombre, existencia, precio_costo, total, id_subconcepto, lote )
values ( nombrei, existenciai, precio_costoi, totali, id_subconceptoi, lotei );

set ban = 1; -- consulta realizada con exito

end$$

create procedure actualiza_articulos
(
in nombrei varchar(50),
in cantidadi int,
in precio_costoi double,
in id_subconceptoi int,
in lotei int,
out ban int
)
begin
declare totali double;
declare existenciai int;

set existenciai = ( select  existencia from articulos where nombre = nombrei and id_subconcepto = id_subconceptoi );

update articulos set existencia = ( existenciai + cantidadi), precio_costo = precio_costoi, total = ( ( existenciai + cantidadi) * precio_costoi)
where nombre = nombrei and id_subconcepto = id_subconceptoi and lote = lotei;

set ban = 1; -- consulta realizada con exito

end$$

create procedure inserta_diario_subconceptos
(
in sub_conceptoi varchar(50),
in saldoi double,
in tipo_operacioni varchar(15),
in nombre_conceptoi varchar(50),
in num_operacioni int,
in id_catalogoi int,
out ban int
)
begin

insert into diario_subconceptos ( sub_concepto, saldo, tipo_operacion, nombre_concepto, num_operacion, id_catalogo,fecha )
values ( sub_conceptoi, saldoi, tipo_operacioni, nombre_conceptoi, num_operacioni, id_catalogoi, CURRENT_TIMESTAMP() );

set ban =1; -- bien

end$$

create procedure inserta_diario
(
in num_operacioni int,
in conceptoi varchar(50),
in saldoi double,
in tipo_operacioni varchar(15),
in id_catalogoi int,
out ban int
)
begin

insert into diario ( num_operacion, fecha, concepto, saldo, tipo_operacion, id_catalogo )
values ( num_operacioni, CURRENT_TIMESTAMP(),conceptoi, saldoi, tipo_operacioni, id_catalogoi );

set ban =1; -- bien

end$$

create procedure borrarDiario
(
in id_catalogoi int,
out ban int
)
begin
delete from diario where id_catalogo = id_catalogoi;
set ban = 1; -- eliminacion correcta

end$$

create procedure borrarDiarioSubConceptos
(
in id_catalogoi int,
out ban int
)
begin
delete from diario_subconceptos where id_catalogo = id_catalogoi;
set ban = 1; -- eliminacion correcta

end$$

create procedure inserta_cuenta
(
in nombrei varchar(50),
in codigoi varchar(15),
in descripcioni varchar(50),
in saldo_deudori double,
in saldo_acreedori double,
in id_catalogoi int,
out ban int
)
begin

if exists ( select id_catalogo from catalogo_de_cuentas where id_catalogo = id_catalogoi )
	then
		insert into cuentas(nombre,codigo,descripcion,saldo_deudor,saldo_acreedor, fecha_creacion, id_catalogo) 
		values(nombrei,codigoi,descripcioni,saldo_deudori,saldo_acreedori, CURRENT_TIMESTAMP(), id_catalogoi);
		set ban = 1; -- si existe
	else
		set ban = -1; -- no existe catalogo
end if;

end$$

create procedure inserta_subcuenta
(
in nombrei varchar(50),
in codigoi varchar(15),
in descripcioni varchar(50),
in saldo_deudori double,
in saldo_acreedori double,
in id_catalogoi int,
out ban int
)
begin

	declare id_cuentai int;
	declare subc varchar(15);
	set subc = ( select substring(codigoi,1,2)  );
	set subc  = ( select concat( subc,"%" ) );
	set id_cuentai = (select id_cuenta from cuentas where codigo like subc and id_catalogo = id_catalogoi);
	insert into sub_cuentas(nombre,codigo,descripcion,saldo_deudor,saldo_acreedor,id_cuenta, fecha_creacion, id_catalogo) 
	values(nombrei,codigoi,descripcioni,saldo_deudori,saldo_acreedori,id_cuentai, CURRENT_TIMESTAMP(), id_catalogoi);

end$$

create procedure inserta_conceptos
(
in nombrei varchar(50),
in codigoi varchar(15),
in descripcioni varchar(50),
in debei double,
in haberi double,
in saldo_deudori double,
in saldo_acreedori double,
in id_catalogoi int,
out ban int
)
begin
	declare id_subcuentai int;
	declare id_cuentai int;
	declare subc varchar(15);

	declare subc2 varchar(15);
	set subc2 = ( select substring(codigoi,1,2)  );
	set subc2  = ( select concat( subc2,"%" ) );

	set subc = ( select substring(codigoi,1,4)  );
	set subc  = ( select concat( subc,"%" ) );
	set id_cuentai = (select id_cuenta from cuentas where codigo like subc2 and id_catalogo = id_catalogoi);
	set id_subcuentai = (select id_subcuenta from sub_cuentas where codigo like subc and id_cuenta = id_cuentai );
	insert into conceptos(nombre,codigo,descripcion,debe,haber,saldo_deudor,saldo_acreedor,id_subcuenta, fecha_creacion, id_catalogo) 
	values(nombrei,codigoi,descripcioni,debei,haberi,saldo_deudori,saldo_acreedori,id_subcuentai, CURRENT_TIMESTAMP(), id_catalogoi);

end$$

create procedure inserta_subconceptos
(
in nombrei varchar(50),
in codigoi varchar(15),
in descripcioni varchar(50),
in padrei int,
in id_catalogoi int,
out ban int
)
begin
	if not exists ( select nombre from  sub_conceptos where nombre = nombrei  and id_concepto = padrei)
	then

	begin
	declare codigoc varchar(15);
	set codigoc =(  select codigo from conceptos where id_concepto = padrei );
	set codigoc = ( select substring(codigoc,1,7)  );
	set codigoc  = ( select concat( codigoc,codigoi ) );
	insert into sub_conceptos(nombre,codigo,descripcion,debe,haber,saldo_deudor,saldo_acreedor,id_concepto, fecha_creacion, id_catalogo) 
	values(nombrei,codigoc,descripcioni,0.0,0.0,0.0,0.0,padrei, CURRENT_TIMESTAMP(), id_catalogoi);
	set ban = 1; -- el concepto se inserto correctamente
	end;

	else
			set ban = -1; -- el concepto ya existe

	end if;

end$$

create procedure crear_empresa
(
in nombrei varchar(50),
in descripcioni varchar(50),
out ban int
)
begin

if exists ( select nombrei from empresas where nombre like nombrei )
	then
		set ban = -1; -- si existe empresa
	else
		insert into empresas(nombre,descripcion,fecha_creacion) values(nombrei,descripcioni,CURRENT_TIMESTAMP());
		set ban = 1; -- no existe empresa
end if;

end$$


create procedure crear_catalogo
(
in nombrei varchar(50),
in id_empresai int,
out ban int
)
begin

if exists ( select nombre from catalogo_de_cuentas where nombre = nombrei and id_empresa = id_empresai)
then
		set ban = -1; -- si existe catalogo
	else
		if not exists ( select id_empresa from empresas where id_empresa = id_empresai )
			then
				set ban = -2; -- no existe esa empresa
			else
				insert into catalogo_de_cuentas(nombre,id_empresa,fecha_creacion) values(nombrei,id_empresai,CURRENT_TIMESTAMP());
				select id_catalogo from catalogo_de_cuentas where nombre = nombrei and id_empresa = id_empresai into ban ; -- no existe catalogo

		end if;
end if;

end$$

create procedure obtener_idcuenta
(
in nombrei varchar(50),
in idcatalogoi int,
out ban int
)
begin

set ban = ( select id_cuenta from cuentas where nombre like nombrei and id_catalogo = idcatalogoi);

end$$

create procedure obtener_idsubcuenta
(
in nombrei varchar(50),
in idcuentai int,
out ban int
)
begin

set ban = ( select id_subcuenta from sub_cuentas where nombre like nombrei and id_cuenta = idcuentai);

end$$

create procedure obtener_idconcepto
(
in nombrei varchar(50),
in id_subcuentai int,
out ban int
)
begin

set ban = ( select id_concepto from conceptos where nombre like nombrei and id_subcuenta = id_subcuentai);

end$$

create procedure obtener_idsubconcepto
(
in nombrei varchar(50),
in id_conceptoi int,
out ban int
)
begin

set ban = ( select id_subconcepto from sub_conceptos where nombre like nombrei and id_concepto = id_conceptoi );

end$$

create procedure borrar_subconceptos
(
in nombrei varchar(50),
in id_conceptoi int,
out ban int
)
begin

delete from sub_conceptos where nombre like nombrei and id_concepto = id_conceptoi ;
set ban = 1;

end$$

create procedure actualiza_subconceptos
(
in nombrei varchar(50),
in id_conceptoi int,
in nombre_nuevo varchar(50),
in descripcioni varchar(50),
out ban int
)
begin

update sub_conceptos set nombre = nombre_nuevo ,descripcion = descripcioni where nombre like nombrei  and id_concepto = id_conceptoi;

set ban = 1;

end$$

create procedure actualizar_subconceptos
(
in nombrei varchar(50),
in id_subconceptoi int,
in cantidadi double,
in tipoi int,
out ban int
)
begin

declare debe_ant double;
declare haber_ant double;
declare debei double;
declare haberi double;
declare cantidad double;

declare saldo_acreedori double;
declare saldo_deudori double;

select debe from sub_conceptos where id_subconcepto = id_subconceptoi into debe_ant;
set debei = ( cantidadi + debe_ant ) ;
select haber from sub_conceptos where id_subconcepto = id_subconceptoi into haber_ant;
set haberi = ( cantidadi + haber_ant ) ;

select saldo_acreedor from sub_conceptos where id_subconcepto = id_subconceptoi into saldo_acreedori;
select saldo_deudor from sub_conceptos where id_subconcepto = id_subconceptoi into saldo_deudori;

if ( tipoi = 1 )
then
		update sub_conceptos set debe = debei where nombre like nombrei  and id_subconcepto = id_subconceptoi;
		set ban = 1;
else
		update sub_conceptos set haber = haberi where nombre like nombrei  and id_subconcepto = id_subconceptoi;
		set ban = 2;

end if;
		select debe from sub_conceptos where id_subconcepto = id_subconceptoi into debe_ant;	
		select haber from sub_conceptos where id_subconcepto = id_subconceptoi into haber_ant;

		set cantidad = debe_ant - haber_ant ;
		if( cantidad < 0 )
			then
				set cantidad = ( cantidad * -1 ) ;		
				update sub_conceptos set saldo_deudor = 0 where id_subconcepto = id_subconceptoi;		
				update sub_conceptos set saldo_acreedor = ( cantidad ) where id_subconcepto = id_subconceptoi;
			else
				update sub_conceptos set saldo_deudor = ( cantidad  ) where id_subconcepto = id_subconceptoi;
				update sub_conceptos set saldo_acreedor = ( 0 ) where id_subconcepto = id_subconceptoi;
		end if;
end$$

-- actualizar conceptos
create procedure actualizar_conceptos
(
in id_conceptoi int,
in cantidadi double,
in tipoi int,
out ban int
)
begin

declare debe_ant double;
declare haber_ant double;
declare cantidad double;
declare debei double;
declare haberi double;

declare saldo_acreedori double;
declare saldo_deudori double;

select debe from conceptos where id_concepto = id_conceptoi into debe_ant;	
set debei = ( cantidadi + debe_ant ) ;
select haber from conceptos where id_concepto = id_conceptoi into haber_ant;
set haberi = ( cantidadi + haber_ant ) ;	

select saldo_acreedor from conceptos where id_concepto = id_conceptoi into saldo_acreedori;
select saldo_deudor from conceptos where id_concepto = id_conceptoi into saldo_deudori;

if ( tipoi = 1 )
then
		update conceptos set debe = debei where id_concepto = id_conceptoi;
		set ban = 1;
else
		update conceptos set haber = haberi where id_concepto = id_conceptoi;
		set ban = 2;

end if;
		select debe from conceptos where id_concepto = id_conceptoi into debe_ant;	
		select haber from conceptos where id_concepto = id_conceptoi into haber_ant;

		set cantidad = debe_ant - haber_ant ;
		if( cantidad < 0 )
			then
				set cantidad = ( cantidad * -1 ) ;		
				update conceptos set saldo_deudor = 0 where id_concepto = id_conceptoi;		
				update conceptos set saldo_acreedor = ( cantidad ) where id_concepto = id_conceptoi;
			else
				update conceptos set saldo_deudor = ( cantidad  ) where id_concepto = id_conceptoi;
				update conceptos set saldo_acreedor = ( 0 ) where id_concepto = id_conceptoi;
		end if;

end$$

-- actualizar sub cuentas
create procedure actualizar_subcuentas
(
in id_subcuentai int,
in cantidadi double,
in tipoi int,
out ban int
)
begin

declare cantidad double;
declare saldo_acreedori double;
declare saldo_deudori double;
select saldo_acreedor from sub_cuentas where id_subcuenta = id_subcuentai into saldo_acreedori;
select saldo_deudor from sub_cuentas where id_subcuenta = id_subcuentai into saldo_deudori;


if ( tipoi = 1 )

then
if( ( saldo_acreedori=0 ) ) -- 2
then
		update sub_cuentas set saldo_deudor = ( cantidadi + saldo_deudori ) where id_subcuenta = id_subcuentai;
		set ban = 1;
else
begin
		set cantidad = saldo_acreedori - cantidadi ;
if( cantidad < 0 )
then
set cantidad = ( cantidad * -1 ) ;
		update sub_cuentas set saldo_deudor = ( cantidad + saldo_deudori ) where id_subcuenta = id_subcuentai;
		update sub_cuentas set saldo_acreedor = 0 where id_subcuenta = id_subcuentai;
		set ban = 2;
else
		update sub_cuentas set saldo_acreedor = ( saldo_acreedori - cantidad ) where id_subcuenta = id_subcuentai;
		set ban = 1;

end if;		
end;
end if; -- 2

else
begin
		set cantidad = saldo_deudori - cantidadi ;
if( cantidad < 0 )
then
set cantidad = ( cantidad * -1 ) ;
		update sub_cuentas set saldo_deudor = 0 where id_subcuenta = id_subcuentai;
		update sub_cuentas set saldo_acreedor = ( cantidad + saldo_acreedori ) where id_subcuenta = id_subcuentai;
		set ban = 2;
else
		update sub_cuentas set saldo_deudor = ( saldo_deudori - cantidad ) where id_subcuenta = id_subcuentai;
		set ban = 1;

end if;		
end;
end if;		

end$$

-- actualizar  cuentas
create procedure actualizar_cuentas
(
in id_cuentai int,
in cantidadi double,
in tipoi int,
out ban int
)
begin

declare cantidad double;
declare saldo_acreedori double;
declare saldo_deudori double;

select saldo_acreedor from cuentas where id_cuenta = id_cuentai into saldo_acreedori;
select saldo_deudor from cuentas where id_cuenta = id_cuentai into saldo_deudori;

if ( tipoi = 1 )

then
if( ( saldo_acreedori=0 ) ) -- 2
then
		update cuentas set saldo_deudor = ( cantidadi + saldo_deudori ) where id_cuenta = id_cuentai;
		set ban = 1;
else
begin
		set cantidad = saldo_acreedori - cantidadi ;
if( cantidad < 0 )
then
set cantidad = ( cantidad * -1 ) ;
		update cuentas set saldo_deudor = ( cantidad + saldo_deudori ) where id_cuenta = id_cuentai;
		update cuentas set saldo_acreedor = 0 where id_cuenta = id_cuentai;
		set ban = 2;
else
		update cuentas set saldo_acreedor = ( saldo_acreedori - cantidad ) where id_cuenta = id_cuentai;
		set ban = 1;

end if;		
end;
end if; -- 2

else
begin
		set cantidad = saldo_deudori - cantidadi ;
if( cantidad < 0 )
then
set cantidad = ( cantidad * -1 ) ;
		update cuentas set saldo_deudor = 0 where id_cuenta = id_cuentai;
		update cuentas set saldo_acreedor = ( cantidad + saldo_acreedori ) where id_cuenta = id_cuentai;
		set ban = 2;
else
		update cuentas set saldo_deudor = ( saldo_deudori - cantidad ) where id_cuenta = id_cuentai;
		set ban = 1;

end if;		
end;
end if;	

end$$

create procedure borrar_empresa
(
in id_empresai int,
out ban int
)
begin
declare id_catalogoi int;

if exists ( select id_empresa from empresas where id_empresa = id_empresai  )
	then
			select id_catalogo from catalogo_de_cuentas where id_empresa = id_empresai into id_catalogoi;
			delete from articulos;
			delete from sub_conceptos where id_catalogo = id_catalogoi;
			delete from conceptos where id_catalogo = id_catalogoi;
			delete from sub_cuentas where id_catalogo = id_catalogoi;
			delete from cuentas where id_catalogo = id_catalogoi;
			delete from diario where id_catalogo = id_catalogoi;
			delete from diario_subconceptos where id_catalogo = id_catalogoi;
			delete from balance_inicial where id_catalogo = id_catalogoi;
			delete from catalogo_de_cuentas where id_catalogo = id_catalogoi;
			delete from empresas where id_empresa = id_empresai ;
set ban = 1; -- si existe la empresa
else
	set ban = -1; -- no existe la empresa
end if;

end$$

create procedure modificar_empresa
(
in id_empresai int,
in nombre_nuevo varchar(50),
in descripcioni varchar(50),
out ban int
)
begin

if exists ( select id_empresa from empresas where id_empresa = id_empresai  )
	then
			if not exists ( select nombre from empresas where nombre = nombre_nuevo  )
				then
						if(nombre_nuevo != '' and descripcioni != '')
							then
								update empresas set nombre = nombre_nuevo ,descripcion = descripcioni where id_empresa = id_empresai ;
								set ban = 1; -- empresa actualizada satisfactoriamente
							else
								if(nombre_nuevo != '')
									then
										update empresas set nombre = nombre_nuevo where id_empresa = id_empresai;
										set ban = -3; -- solo se actualizo el nombre
									else
										if(descripcioni != '')
											then
												update empresas set descripcion = descripcioni where id_empresa = id_empresai;
												set ban = -4; -- solo se actualizo la descripcion
											else
												set ban = -5; -- no se realizaron cambios
										end if;

								end if;
						end if;

				else
						set ban = -2; -- ya existe esa empresa
			end if;
else
	set ban = -1; -- no existe la empresa a modificar

end if;

end$$

create procedure borrar_catalogo
(
in id_catalogoi int,
in id_empresai int,
out ban int
)
begin

if exists ( select id_catalogo from catalogo_de_cuentas where id_catalogo = id_catalogoi  )
	then
if exists ( select id_empresa from empresas where id_empresa = id_empresai  )
then
			delete from sub_conceptos where id_catalogo = id_catalogoi;
			delete from conceptos where id_catalogo = id_catalogoi;
			delete from sub_cuentas where id_catalogo = id_catalogoi;
			delete from cuentas where id_catalogo = id_catalogoi;
			delete from diario where id_catalogo = id_catalogoi;
			delete from diario_subconceptos where id_catalogo = id_catalogoi;
			delete from balance_inicial where id_catalogo = id_catalogoi;	
			delete from catalogo_de_cuentas where id_catalogo = id_catalogoi and id_empresa = id_empresai ;
			set ban = 1; -- si existe lel catalogo
else
		set ban = -2; -- no existe empresa
end if;

else
	set ban = -1; -- no existe el catalogo

end if;

end$$

create procedure modificar_catalogo
(
in id_empresai int,
in id_catalogoi int,
in nombre_nuevo varchar(50),
out ban int
)
begin

if exists ( select id_empresa from empresas where id_empresa = id_empresai  )
	then
			if not exists ( select nombre from catalogo_de_cuentas where nombre = nombre_nuevo  )
				then
						if(nombre_nuevo != '')
							then
								update catalogo_de_cuentas set nombre = nombre_nuevo where id_catalogo = id_catalogoi and id_empresa = id_empresai ;
								set ban = 1; -- bien
							else
								set ban = -3; -- no se realizaron modificaciones
						end if;
				else
						set ban = -2; -- ya existe esa catalogo
			end if;
	else
		set ban = -1; -- no existe la empresa

end if;

end$$

create procedure cargar_cuentas
(
in id_catalogoi int,
out ban int
)
begin

-- inserta cuentas
call inserta_cuenta("Activo","1-0-00-000","Cuenta de activos",0.0,0.0,id_catalogoi,@ban);
call inserta_cuenta("Pasivo","2-0-00-000","Cuenta de pasivos",0.0,0.0,id_catalogoi,@ban);
call inserta_cuenta("Resultados","3-0-00-000","Cuenta de Resultados",0.0,0.0,id_catalogoi,@ban);

set ban = 1; -- tood bien

end$$

create procedure cargar_subcuentas
(
in id_catalogoi int,
out ban int
)
begin

-- inserta activos subcuenta
call inserta_subcuenta("Circulante","1-1-00-000","Cuenta de activos circulante",0.0,0.0,id_catalogoi,@ban);
call inserta_subcuenta("Fijo","1-2-00-000","Cuenta de activo fijo",0.0,0.0,id_catalogoi,@ban);
call inserta_subcuenta("Diferido","1-3-00-000","Cuenta de activo diferido",0.0,0.0,id_catalogoi,@ban);

-- inserta pasivos subcuenta
call inserta_subcuenta("Circulante","2-1-00-000","Cuenta de pasivo circulante",0.0,0.0,id_catalogoi,@ban);
call inserta_subcuenta("Fijo","2-2-00-000","Cuenta de pasivo fijo",0.0,0.0,id_catalogoi,@ban);
call inserta_subcuenta("Diferido","2-3-00-000","Cuenta de pasivo diferido",0.0,0.0,id_catalogoi,@ban);

-- inserta Resultados subcuenta
call inserta_subcuenta("Capital","3-1-00-000","Cuenta de capital",0.0,0.0,id_catalogoi,@ban);
call inserta_subcuenta("Resultados Acreedoras","3-2-00-000","Cuenta de Resultados Acreedoras",0.0,0.0,id_catalogoi,@ban);
call inserta_subcuenta("Resultados Deudores","3-3-00-000","Cuenta de Resultados Deudores",0.0,0.0,id_catalogoi,@ban);

set ban = 1; -- tood bien

end$$

create procedure cargar_conceptos
(
in id_catalogoi int,
out ban int
)
begin

-- inserta resultados capital subcuenta
call inserta_conceptos("Capital Social","3-1-01-000","Cuenta de Capital Social",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Capital Contable","3-1-02-000","Cuenta de Capital Contable",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Utilidad o perdida del ejercicio","3-1-03-000","Cuenta de perdidas y ganancias",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

-- inserta resultados acreedoras subcuenta
call inserta_conceptos("Ventas","3-2-01-000","Cuenta de ventas",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Devoluciones sobre Ventas","3-2-02-000","Cuenta de Devoluciones sobre Ventas",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Descuentos sobre Ventas","3-2-03-000","Cuenta de Descuentos sobre Ventas",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

-- inserta resultados deudoras subcuenta
call inserta_conceptos("Gastos de venta","3-3-01-000","Cuenta id_catalogoide Gastos de venta",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Gastos administrativos","3-3-02-000","Cuenta de Gastos administrativos",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Costo de venta","3-3-03-000","Cuenta de Costo de venta",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Compras","3-3-04-000","Cuenta de Compras",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Gastos sobre Compras","3-3-05-000","Cuenta de Gastos sobre Compras",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Devoluciones sobre Compras","3-3-06-000","Cuenta de Devoluciones sobre Compras",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Descuentos sobre Compras","3-3-07-000","Cuenta de Descuentos sobre Compras",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

-- inserta conceptos activo circulante
call inserta_conceptos("Caja","1-1-01-000","Concepto de caja",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Bancos","1-1-02-000","Concepto de Bancos",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Inventario","1-1-03-000","Concepto de Inventario",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Clientes","1-1-04-000","Concepto de Clientes",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Documentos por cobrar","1-1-05-000","Concepto de Documentos por cobrar",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Deudores diversos","1-1-06-000","Concepto de Deudores diversos",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

-- inserta conceptos activo fijo
call inserta_conceptos("Terrenos","1-2-01-000","Concepto de Terrenos",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Edificios","1-2-02-000","Concepto de Edificios",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("MOBILIARIO Y EQUIPO DE OFICINA","1-2-03-000","Concepto de MOBILIARIO Y EQUIPO DE OFICINA",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("EQUIPO DE ENTREGA Y DE REPARTO","1-2-04-000","Concepto de EQUIPO DE ENTREGA Y DE REPARTO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("DEPOSITOS EN GARANTIA","1-2-05-000","Concepto de DEPOSITOS EN GARANTIA",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("ACCIONES Y VALORES","1-2-06-000","Concepto de ACCIONES Y VALORES",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("EQUIPO ELECTRONICO","1-2-07-000","Concepto de EQUIPO ELECTRONICO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Equipo de transporte","1-2-08-000","Concepto de Equipo de transporte",0.0,0.0,0.0,0.0,id_catalogoi,@ban);


-- inserta conceptos activo diferido
call inserta_conceptos("GASTOS DE INSTALACION Y ADAPTACION","1-3-01-000","Concepto de GASTOS DE INSTALACIÓN Y ADAPTACIÓN",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("PROPAGANDA Y PUBLICIDAD","1-3-02-000","Concepto de PROPAGANDA Y PUBLICIDAD",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("IMPUESTOS ANTICIPADOS","1-3-03-000","Concepto de IMPUESTOS ANTICIPADOS",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("RENTAS PAGADAS POR ANTICIPADO","1-3-04-000","Concepto de RENTAS PAGADAS POR ANTICIPADO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("INTERESES PAGADOS POR ANTICIPADO","1-3-05-000","Concepto de INTERESES PAGADOS POR ANTICIPADO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Papeleria y utiles","1-3-06-000","Concepto de Papeleria y utiles",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("Primas de seguro","1-3-07-000","Concepto de Primas de seguro",0.0,0.0,0.0,0.0,id_catalogoi,@ban);


-- inserta conceptos pasivo circulante
call inserta_conceptos("PROVEEDORES","2-1-01-000","Concepto de PROVEEDORES",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("DOCUMENTOS POR PAGAR","2-1-02-000","Concepto de DOCUMENTOS POR PAGAR",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("ACREEDORES DIVERSOS","2-1-03-000","Concepto de ACREEDORES DIVERSOS",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

-- inserta conceptos pasivo fijo
call inserta_conceptos("DOCUMENTOS A PAGAR A LARGO PLAZO","2-2-01-000","Concepto de DOCUMENTOS A PAGAR A LARGO PLAZO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("ACREEDORES HIPOTECARIOS","2-2-02-000","Concepto de ACREEDORES HIPOTECARIOS",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

-- inserta conceptos pasivo diferido
call inserta_conceptos("INTERESES COBRADOS POR ADELANTADO","2-3-01-000","Concepto de INTERESES COBRADOS POR ADELANTADO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);
call inserta_conceptos("RENTAS COBRADAS POR ANTICIPADO","2-3-02-000","Concepto de RENTAS COBRADAS POR ANTICIPADO",0.0,0.0,0.0,0.0,id_catalogoi,@ban);

set ban = 1; -- tood bien

end$$


create procedure calcular_capital_contable
(
in id_catalogoi int,
out ban double
)
begin
declare id_cuentai int;
declare id_subcuentai int;
declare saldo_activo double;
declare saldo_pasivo double;
declare cantidad double;

call obtener_idcuenta("resultados",id_catalogoi,@ban)  ;
select  @ban into id_cuentai ;

call obtener_idsubcuenta("capital",id_cuentai,@ban)  ;
select  @ban into id_subcuentai ;

-- saldo pasivo
select saldo_deudor from cuentas where nombre like "Activo" and id_catalogo = id_catalogoi into saldo_activo;
if( saldo_activo = 0 )
then
select saldo_acreedor from cuentas where nombre like "Activo" and id_catalogo = id_catalogoi into saldo_activo;
end if;

-- saldo activo
select saldo_deudor from cuentas where nombre like "Pasivo" and id_catalogo = id_catalogoi into saldo_pasivo;
if( saldo_pasivo = 0 )
then
select saldo_acreedor from cuentas where nombre like "Pasivo" and id_catalogo = id_catalogoi into saldo_pasivo;
end if;

set cantidad = ( saldo_activo - saldo_pasivo );

set ban = cantidad;

end$$

create procedure obtener_saldo_activo
(
in id_catalogoi int,
out ban double
)
begin
declare saldo_activo double;

-- saldo activo
select saldo_deudor from cuentas where nombre like "Activo" and id_catalogo = id_catalogoi into saldo_activo;
if( saldo_activo = 0 )
then
select saldo_acreedor from cuentas where nombre like "Activo" and id_catalogo = id_catalogoi into saldo_activo;
end if;



set ban = saldo_activo;

end$$

create procedure obtener_saldo_pasivo
(
in id_catalogoi int,
out ban double
)
begin
declare saldo_pasivo double;

-- saldo activo
select saldo_deudor from cuentas where nombre like "Pasivo" and id_catalogo = id_catalogoi into saldo_pasivo;
if( saldo_pasivo = 0 )
then
select saldo_acreedor from cuentas where nombre like "Pasivo" and id_catalogo = id_catalogoi into saldo_pasivo;
end if;

set ban = saldo_pasivo;

end$$

create procedure saldo_total
(
in id_catalogoi int,
in nombre_cuentai varchar(50),
in nombre_subcuentai varchar(50),
in nombre_conceptoi varchar(50),
out ban double
)
begin

declare id_cuentai int;
declare id_subcuentai int;
declare saldo double;
declare cantidad double;

call obtener_idcuenta(nombre_cuentai,id_catalogoi,@ban)  ;
select  @ban into id_cuentai ;

call obtener_idsubcuenta(nombre_subcuentai,id_cuentai,@ban)  ;
select  @ban into id_subcuentai ;

-- saldo ventas
select saldo_deudor from conceptos where nombre like nombre_conceptoi and id_subcuenta = id_subcuentai into saldo;
if( saldo = 0 )
then
select saldo_acreedor from conceptos where nombre like nombre_conceptoi and id_subcuenta = id_subcuentai into saldo;
end if;

set ban = saldo;

end$$

/*

create procedure inserta_usuario
(
)
begin

if not exists ( select user from user )
then
create user Swc identified by '';

end if;

end$$
*/

create procedure capital_social
(
in id_catalogoi int,
out ban double
)
begin

set ban = ( select capital_contable from balance_inicial where id_catalogo = id_catalogoi );

end$$

create procedure borrar_articulo
(
in id_subconceptoi int,
in nombrei varchar(50),
out ban int
)
begin

delete from articulos where id_subconcepto = id_subconceptoi and nombre like nombrei ;
set ban = 1;

end$$

