select
	k.id,
	k.keyword,
	k.description,
	usr.user_name
from 
	keyword k
join
	users usr
on
	k.user_id = usr.user_id;


