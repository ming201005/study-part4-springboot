
SELECT a.user_name,
       b.role_name
from sys_user_table a,
	 sys_role_table b,
     sys_role_user_table c
where a.user_id = c.user_id
     and b.role_id = c.role_id
     and a.state = 1