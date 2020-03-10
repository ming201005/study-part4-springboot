/**
 思路：
   1、查询API管理表sys_backend_api_table，作为主表。
   2、 sys_backend_api_table、sys_role_table、sys_role_backend_api_table
       这三张表内关联查询得到数据，作为右表
   3、将1、2作左右关联进行查询，得到的结果是所有的结果和被分配后的API对应角色ID
   4、当页面需要显示时，可以清晰的看到哪些已陪分配

   相似模块：角色-前端菜单分配、角色-用户分配。
 */

select
  t1.backend_api_id as id,
  CASE t1.backend_api_url
  WHEN 'none' THEN t1.backend_api_name
  ELSE  CONCAT(t1.backend_api_name,' (',t1.backend_api_url,')')
  END as name ,
  t1.pid as pid,
  t2.role_id as role_id
from sys_backend_api_table t1
left join
(
   select
     a.backend_api_id,
     a.backend_api_name,
     a.pid,
     a.backend_api_sort,
     b.role_id
   from sys_backend_api_table a,
     sys_role_table b,
     sys_role_backend_api_table c
   where  a.backend_api_id = c.backend_api_id
	 and b.role_id = c.role_id
     and b.role_id = '1'
) t2 on t2.backend_api_id = t1.backend_api_id
   order by t1.backend_api_sort asc