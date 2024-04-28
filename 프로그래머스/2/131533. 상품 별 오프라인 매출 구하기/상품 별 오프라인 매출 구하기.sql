select P.product_code, sum(O.sales_amount) * P.price as sales
from product as P
inner join offline_sale as O
on P.product_id = O.product_id
GROUP BY p.PRODUCT_CODE
order by sales desc, product_code asc