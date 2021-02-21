select artist.artist_name, count(listener_artist_interest.artist_interest_id) as number_of_follower
from artist left join listener_artist_interest on artist.artist_id = listener_artist_interest.artist_interest_id
group by artist.artist_name