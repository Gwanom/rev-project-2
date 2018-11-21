/*
    Spotigram Database v0.1.2
*/

SET SCHEMA 'spotigram';

CREATE TABLE roles (
    sg_role_id SERIAL,
    role_name TEXT NOT NULL,

    CONSTRAINT sg_role_pk PRIMARY KEY (sg_role_id)
);


CREATE TABLE users (

    sg_user_id SERIAL, 
    username TEXT NOT NULL UNIQUE,
    u_password TEXT NOT NULL,
    user_first_name TEXT NOT NULL,
    user_last_name TEXT NOT NULL,
    user_email TEXT NOT NULL UNIQUE,
    user_role INTEGER NOT NULL,
    isBanned BOOLEAN NOT NULL,

    CONSTRAINT sg_user_PK PRIMARY KEY (sg_user_id),
	FOREIGN KEY (user_role) REFERENCES roles (sg_role_id)
);

CREATE TABLE artists (
    artist_id SERIAL,
    artist_name TEXT NOT NULL,
	
	CONSTRAINT sg_artist_PK PRIMARY KEY (artist_id)
);

CREATE TABLE albums (
    album_id SERIAL,
    album_title TEXT NOT NULL,
    artist INTEGER NOT NULL,

    CONSTRAINT sg_album_PK PRIMARY KEY (album_id),
	FOREIGN KEY (artist) REFERENCES artists(artist_id)
);


CREATE TABLE songs (
    sg_song_id SERIAL,
    song_title TEXT NOT NULL,
    album INTEGER NOT NULL,
    artist INTEGER NOT NULL,
    video TEXT,
    audio_sample TEXT,

    CONSTRAINT sg_song_PK PRIMARY KEY (sg_song_id),
	FOREIGN KEY (album) REFERENCES albums (album_id),
	FOREIGN KEY (artist) REFERENCES artists (artist_id)
);

CREATE TABLE posts (
    sg_post_id SERIAL,
    author_id INTEGER NOT NULL,
    topic_song INTEGER NOT NULL,
    topic_album INTEGER NOT NULL,
    topic_artist INTEGER NOT NULL,
    content TEXT NOT NULL,

    CONSTRAINT sg_post_PK PRIMARY KEY (sg_post_id),
	FOREIGN KEY (author_id) REFERENCES users (sg_user_id),
    FOREIGN KEY (topic_song) REFERENCES songs (sg_song_id),
    FOREIGN KEY (topic_album) REFERENCES albums (album_id),
    FOREIGN KEY (topic_artist) REFERENCES artists (artist_id)
);


CREATE TABLE replies (
    sg_reply_id SERIAL,
    parent INTEGER NOT NULL,
    author INTEGER NOT NULL,
    content TEXT NOT NULL,

    CONSTRAINT sg_reply_PK PRIMARY KEY (sg_reply_id),
	FOREIGN KEY (parent) REFERENCES posts (sg_post_id),
	FOREIGN KEY (author) REFERENCES users (sg_user_id)
);







