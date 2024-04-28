select B.book_id, A.author_name, date_format(B.published_date, '%Y-%m-%d') as published_date
from book as B, author as A
where B.author_id = A.author_id and B.category = '경제'
order by B.published_date