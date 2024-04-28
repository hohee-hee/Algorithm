select B.title,
        B.board_id, 
        R.reply_id, 
        R.writer_id,
        R.contents,
        date_format(R.created_date, '%Y-%m-%d') as created_id
from used_goods_board as B,
        used_goods_reply as R
where B.board_id = R.board_id and B.created_date between '2022-10-01' and '2022-10-31'
order by R.created_date asc, B.title asc