-- 코드를 입력하세요
SELECT a.flavor
FROM first_half as a
INNER JOIN july as b 
ON a.flavor = b.flavor
GROUP BY a.flavor
ORDER BY SUM(a.total_order) + SUM(b.total_order) DESC
LIMIT 3;
