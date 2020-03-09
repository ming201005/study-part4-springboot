select DISTINCT a.backend_api_url
from sys_backend_api_table a,
     sys_role_table b,
     sys_role_backend_api_table c,
     sys_user_table d,
     sys_role_user_table e
where a.backend_api_id = c.backend_api_id
     and a.backend_api_url <> 'none'
	 and b.role_id = c.role_id
     and d.user_id = e.user_id
     and e.role_id = c.role_id
     and d.user_name='张三'