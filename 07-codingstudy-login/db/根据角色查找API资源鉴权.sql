select DISTINCT a.backend_api_url
from sys_backend_api_table a, sys_role_table b, sys_role_backend_api_table c
where a.backend_api_id = c.backend_api_id
     -- 去掉api url为none的，为none的api是特殊的处理，是为了api好管理，做分类
     and a.backend_api_url <> 'none'
	 and b.role_id = c.role_id
	 -- 例如：ROLE_ADMIN、ROLE_SHOP_MANAGER
     and b.role_name in('ROLE_ADMIN','ROLE_SHOP_MANAGER')