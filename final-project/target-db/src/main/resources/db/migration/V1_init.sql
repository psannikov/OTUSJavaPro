--Сделать под SYS на новой базе перед началом демонстрации
create user USER_IS_1 identified by "123";
grant connect to USER_IS_1;
alter user USER_IS_1 default role connect;
grant alter user to system with admin option;
/
--Сделать под SYSTEM перед началом работы
create or replace function change_password(login varchar2, psw varchar2) return varchar2 as
PRAGMA AUTONOMOUS_TRANSACTION;
begin
execute immediate 'alter user '||login||' IDENTIFIED by "'||psw||'"';
return 'Пароль успешно обновлен';
exception when others then return 'Что-то пошло не так: '||sqlerrm;
end;
/
create table auths (id number, login varchar2(50 byte), result_code number, result_description varchar2(1000 byte), idate date);