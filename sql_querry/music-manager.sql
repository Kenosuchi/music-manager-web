CREATE SCHEMA `music-manager` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
create table `music-manager`.role(
	role_id int not null auto_increment,
    role_name varchar(45) not null,
    primary key (role_id)
);
create table `music-manager`.user_account(
	account_id int not null auto_increment,
    account_username varchar(45) not null,
    account_password varchar(100) not null,
    account_role int not null,
    primary key (account_id),
    foreign key (account_role) references role(role_id)
);
create table `music-manager`.genre(
	genre_id int not null auto_increment,
    genre_name varchar(100) not null,
    primary key (genre_id)
);
create table `music-manager`.artist(
	artist_id int not null auto_increment,
    artist_name varchar(100) not null,
    artist_description varchar(255),
    artist_account int not null,
    primary key (artist_id),
    foreign key (artist_account) references user_account(account_id)
);
create table `music-manager`.listener(
	listener_id int not null auto_increment,
    listener_account int not null,
    listener_name varchar(100) not null,
    primary key (listener_id),
    foreign key (listener_account) references user_account(account_id)
);
create table `music-manager`.playlist(
	playlist_id int not null auto_increment,
    playlist_title varchar(100),
    playlist_update_date date,
    playlist_listener int,
    primary key(playlist_id),
    foreign key(playlist_listener) references listener(listener_id)
);
create table `music-manager`.song(
	song_id int not null auto_increment,
    song_title varchar(100) not null,
    song_artist int not null,
    song_genre int not null,
    song_release_date date,
    song_playtime int,
    primary key (song_id),
    foreign key (song_artist) references artist(artist_id),
    foreign key (song_genre) references genre(genre_id)
);
create table `music-manager`.album(
	album_id int not null auto_increment,
    album_title varchar(100) not null,
    album_description varchar(255) not null,
    album_updated_date date,
    primary key (album_id)
);

create table `music-manager`.playlist_song(
	playlist_id int not null,
    song_id int not null,
    foreign key (playlist_id) references playlist(playlist_id),
    foreign key (song_id) references song(song_id)
);
create table `music-manager`.album_song(
	album_id int not null,
    song_id int not null,
    foreign key (album_id) references album(album_id),
    foreign key (song_id) references song(song_id)
);
create table `music-manager`.song_like(
	song_id int not null,
    listener_like_id int not null,
    foreign key (song_id) references song(song_id),
    foreign key (listener_like_id) references listener(listener_id)
);
create table `music-manager`.album_like(
	album_id int not null,
    listener_like_id int not null,
    foreign key (album_id) references album(album_id),
    foreign key (listener_like_id) references listener(listener_id)
);
create table `music-manager`.listener_artist_interest(
	listener_id int not null,
    artist_interest_id int not null,
    foreign key (listener_id) references listener(listener_id),
    foreign key (artist_interest_id) references artist(artist_id)
);

