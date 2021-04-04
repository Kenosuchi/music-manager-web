insert into `music-manager`.role(role_name) values ('ROLE_ADMIN');
insert into `music-manager`.role(role_name) values ('ROLE_ARTIST');
insert into `music-manager`.role(role_name) values ('ROLE_LISTENER');

insert into `music-manager`.user_account(account_username, account_password, account_role) values ('webadmin','$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.',1);
insert into `music-manager`.user_account(account_username, account_password, account_role) values ('artist_1','$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.',2);
insert into `music-manager`.user_account(account_username, account_password, account_role) values ('artist_2','$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.',2);
insert into `music-manager`.user_account(account_username, account_password, account_role) values ('listener_1','$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.',3);
insert into `music-manager`.user_account(account_username, account_password, account_role) values ('listener_2','$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.',3);
        
insert into `music-manager`.genre(genre_name) values ('genre 1');
insert into `music-manager`.genre(genre_name) values ('genre 2');

insert into `music-manager`.artist(artist_name, artist_description, artist_account) values ('artist one','this is description of artist 1','2');
insert into `music-manager`.artist(artist_name, artist_description, artist_account) values ('artist two','this is description of artist 2','3');

insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 1 artist 1',1,1,"2020-01-01",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 2 artist 1',1,2,"2015-01-03",120);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 3 artist 1',1,2,"2021-05-01",150);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 4 artist 2',2,1,"2018-12-06",320);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 5 artist 3',2,2,"2019-10-08",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 1 artist 1',1,1,"2020-01-01",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 2 artist 1',1,2,"2015-01-03",120);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 3 artist 1',1,2,"2021-05-01",150);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 4 artist 2',2,1,"2018-12-06",320);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 5 artist 3',2,2,"2019-10-08",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 12 artist 1',1,1,"2020-01-01",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 23 artist 1',1,2,"2015-01-03",120);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 34 artist 1',1,2,"2021-05-01",150);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 4 artist 2',2,1,"2018-12-06",320);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 5 artist 3',2,2,"2019-10-08",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 11 artist 1',1,1,"2020-01-01",100);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 22 artist 1',1,2,"2015-01-03",120);
insert into `music-manager`.song(song_title, song_artist, song_genre, song_release_date,song_playtime) values ('song title 33 artist 1',1,2,"2021-05-01",150);

insert into `music-manager`.listener(listener_account, listener_name) values (4,'listener one');
insert into `music-manager`.listener(listener_account, listener_name) values (5,'listener two');

insert into `music-manager`.album(album_title, album_description,album_updated_date) values ('album title one','this is description of album 1',"2020-11-03");
insert into `music-manager`.album(album_title, album_description,album_updated_date) values ('album title two','this is description of album 2',"2018-12-13");

insert into `music-manager`.playlist(playlist_title, playlist_update_date,playlist_listener) values ("playlist 1","2018-02-20",1);
insert into `music-manager`.playlist(playlist_title, playlist_update_date,playlist_listener) values ("playlist 2","2019-04-16",2);
insert into `music-manager`.playlist(playlist_title, playlist_update_date,playlist_listener) values ("playlist 3","2020-08-26",1);

insert into `music-manager`.playlist_song(playlist_id, song_id) values (1,1);
insert into `music-manager`.playlist_song(playlist_id, song_id) values (2,1);
insert into `music-manager`.playlist_song(playlist_id, song_id) values (1,2);
insert into `music-manager`.playlist_song(playlist_id, song_id) values (2,3);
insert into `music-manager`.playlist_song(playlist_id, song_id) values (3,4);
insert into `music-manager`.playlist_song(playlist_id, song_id) values (3,1);

insert into `music-manager`.album_song(album_id, song_id) values (1,1);
insert into `music-manager`.album_song(album_id, song_id) values (1,3);
insert into `music-manager`.album_song(album_id, song_id) values (1,5);
insert into `music-manager`.album_song(album_id, song_id) values (2,1);
insert into `music-manager`.album_song(album_id, song_id) values (2,4);

insert into `music-manager`.song_like(song_id, listener_like_id) values (1,1);
insert into `music-manager`.song_like(song_id, listener_like_id) values (2,1);
insert into `music-manager`.song_like(song_id, listener_like_id) values (2,2);

insert into `music-manager`.album_like(album_id, listener_like_id) values (1,1);
insert into `music-manager`.album_like(album_id, listener_like_id) values (1,2);
insert into `music-manager`.album_like(album_id, listener_like_id) values (2,2);

insert into `music-manager`.listener_artist_interest(listener_id, artist_interest_id) values (1,1);
insert into `music-manager`.listener_artist_interest(listener_id, artist_interest_id) values (1,2);
insert into `music-manager`.listener_artist_interest(listener_id, artist_interest_id) values (2,2);
