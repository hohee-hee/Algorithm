select concat(format(length, 2), 'cm') as MAX_LENGTH
from fish_info
order by length desc limit 1
