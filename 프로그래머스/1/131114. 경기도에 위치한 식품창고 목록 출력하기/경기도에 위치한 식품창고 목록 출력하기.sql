select 
    warehouse_id, 
    warehouse_name, 
    address, 
    case freezer_yn when 'Y' then 'Y' else 'N' end
from food_warehouse
where address like '경기도%'
order by warehouse_id asc