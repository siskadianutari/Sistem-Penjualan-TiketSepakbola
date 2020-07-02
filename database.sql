SQL> create tablespace siskaD_06954
  2  datafile 'D:\modul1_BD.bdf'
  3  size 30M;

Tablespace created.

SQL> create user siska06954
  2  identified by siska
  3  default tablespace siskaD_06954
  4  quota 30M on siskaD_06954;

User created.
SQL> create table pembeli_06954
  2  (
  3  nik number(20) not null
  4  ,
  5  nama_pembeli varchar2(20),
  6  jenis_kelamin varchar2(20),
  7  alamat varchar2(20),
  8  no_telp number(13),
  9  constraint PK_pembeli primary key (nik)
 10  );

Table created.
SQL> create table transaksi_06954
  2  (
  3  id_transaksi integer not null,
  4  tgl_transaksi date,
  5  nik number(20),
  6  harga_total number(20),
  7  constraint PK_transaksi primary key (id_transaksi)
  8  );

Table created.

SQL> create table detail_transaksi_06954
  2  (
  3  id_transaksi integer,
  4  id_tiket integer,
  5  jumlah number(20)
  6  );

Table created.
SQL> create table jenis_tiket_06954
  2  (
  3  id_tiket integer not null,
  4  nama_tiket varchar2(20),
  5  harga_tiket number(20)
  6  );

Table created.
SQL> alter table detail_transaksi_06954
  2  add constraint FK_id_transaksi foreign key (id_transaksi)
  3  references transaksi_06954(id_transaksi)
  4  add constraint FK_id_tiket foreign key (id_tiket)
  5  references jenis_tiket_06954(id_tiket);

Table altered.
SQL> create sequence id_transaksi
  2  minvalue 1
  3  maxvalue 99
  4  start with 1
  5  increment by 1
  6  cache 20;

Sequence created.
SQL> alter table pembeli_06954
  2  rename column nama_pembeli to nama_06954;

Table altered.
SQL> alter table pembeli_06954
  2  add constraint UN_alamat unique (alamat);

Table altered.
SQL> alter table pembeli_06954
  2  modify alamat varchar2(50);

Table altered.
SQL> insert into Pembeli_06954(nik, nama_06954, jenis_kelamin, alamat, no_telp) values ('1', 'Jeje', 'laki-laki', 'surabaya', '345678912');

1 row created.

SQL> insert into Pembeli_06954(nik, nama_06954, jenis_kelamin, alamat, no_telp) values ('2', 'Agis', 'perempuan', 'krian', '456789123');

1 row created.

SQL>
SQL> insert all
  2      into Pembeli_06954(nik, nama_06954, jenis_kelamin, alamat, no_telp) values ('4', 'Siska Dian', 'perempuan', 'nganjuk', '123456789')
  3      into Pembeli_06954(nik, nama_06954, jenis_kelamin, alamat, no_telp) values ('5', 'Doni', 'laki-laki', 'mojokerto', ' 234567891')
  4      into Pembeli_06954(nik, nama_06954, jenis_kelamin, alamat, no_telp) values ('3', 'Dika', 'laki-laki', 'sidoarjo', '567891234')
  5      select 1 from dual;

3 rows created.
SQL> insert into Transaksi_06954(id_transaksi, tgl_transaksi, nik, harga_total) values (id_transaksi.nextval, to_date('28/02/2020','dd/mm/yyyy'), '1', '25000');
1 row created.

SQL> insert into Transaksi_06954(id_transaksi, tgl_transaksi, nik, harga_total) values (id_transaksi.nextval, to_date('01/03/2020','dd/mm/yyyy'), '2', '50000');
1 row created.

SQL>  insert into Transaksi_06954(id_transaksi, tgl_transaksi, nik, harga_total) values (id_transaksi.nextval, to_date('05/03/2020','dd/mm/yyyy'), '3', '100000');
1 row created.

SQL> insert into Transaksi_06954(id_transaksi, tgl_transaksi, nik, harga_total) values (id_transaksi.nextval, to_date('09/03/2020','dd/mm/yyyy'), '4', '25000');
1 row created.

SQL> insert into Transaksi_06954(id_transaksi, tgl_transaksi, nik, harga_total) values (id_transaksi.nextval, to_date('15/03/2020','dd/mm/yyyy'), '5', '50000');

1 row created.
SQL>  insert into Jenis_Tiket_06954(id_tiket, nama_tiket, harga_tiket) values ('1', 'ekonomi', '25000');

1 row created.

SQL> insert into Jenis_Tiket_06954(id_tiket, nama_tiket, harga_tiket) values ('2', 'vip', '50000');

1 row created.

SQL> insert all
  2      into Jenis_Tiket_06954(id_tiket, nama_tiket, harga_tiket) values ('3', 'vvip', '100000')
  3      into Jenis_Tiket_06954(id_tiket, nama_tiket, harga_tiket) values ('4', 'ekonomi', '25000')
  4      into Jenis_Tiket_06954(id_tiket, nama_tiket, harga_tiket) values ('5', 'vip', '50000')
  5      select 1 from dual;

3 rows created.
SQL> insert into Detail_Transaksi_06954(id_transaksi, id_tiket, jumlah) values (18, 1, '2');

1 row created.

SQL> insert into Detail_Transaksi_06954(id_transaksi, id_tiket, jumlah) values (19, 2, '3');

1 row created.

SQL> insert all
     into Detail_Transaksi_06954(id_transaksi, id_tiket, jumlah) values (13, 3, '4')
     into Detail_Transaksi_06954(id_transaksi, id_tiket, jumlah) values (16, 4, '5')
     into Detail_Transaksi_06954(id_transaksi, id_tiket, jumlah) values (17, 5, '6')
     select 1 from dual;

3 rows created.
SQL> update pembeli_06954 set alamat = 'surabaya' where nama_06954 = 'Jeje';

1 row updated.

SQL> update pembeli_06954 set alamat = 'krian' where nama_06954 = 'Agis';

1 row updated.

SQL> update pembeli_06954 set alamat = 'nganjuk' where nama_06954 = 'Siska Dian';

1 row updated.

SQL> update pembeli_06954 set alamat = 'mojokertob' where nama_06954 = 'Doni';

1 row updated.

SQL> update pembeli_06954 set alamat = 'sidoarjo' where nama_06954 = 'Dika';

1 row updated.
SQL> delete from detail_transaksi_06954 where id_transaksi = '17' and jumlah = '6';

1 row deleted.

SQL> delete from detail_transaksi_06954 where id_transaksi = '16' and jumlah = '5';

1 row deleted.

SQL> delete from detail_transaksi_06954 where id_transaksi = '13' and jumlah = '2';

1 row deleted.

SQL> delete from detail_transaksi_06954 where id_transaksi = '13' and jumlah = '2';

1 row deleted.

SQL> delete from detail_transaksi_06954 where id_transaksi = '14' and jumlah = '3';

1 row deleted.
SQL> commit;

Commit complete.
SQL> savepoint Sandy;

Savepoint created.
SQL> rollback to Sandy;

Rollback complete.
SQL> select jenis_kelamin from pembeli_06954 group by jenis_kelamin;

SQL< create view data_pembeli 
2 as select * from pembeli_06954; 

View created. 

SQL> select * from join;