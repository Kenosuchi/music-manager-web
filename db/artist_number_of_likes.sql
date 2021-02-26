select artist.artist_id,artist.artist_name,artist.artist_description, count(listener_artist_interest.artist_interest_id) as artist_followers
from artist left join listener_artist_interest on artist.artist_id = listener_artist_interest.artist_interest_id
group by artist.artist_name