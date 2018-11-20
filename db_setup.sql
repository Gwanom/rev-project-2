/*
    Spotigram Database v0.1.0
*/

SET SCHEMA 'spotigram';

CREATE TABLE users (

    sg_user_id SERIAL, 
    username TEXT NOT NULL UNIQUE,
    u_password TEXT NOT NULL,
    user_first_name TEXT NOT NULL,
    user_last_name TEXT NOT NULL,
    user_email TEXT NOT NULL UNIQUE,
    user_role INTEGER REFERENCES roles (role_id),
    isBanned BOOLEAN NOT NULL,

    CONSTRAINT sg_user_PK PRIMARY KEY (sg_user_id)
);

CREATE TABLE roles (
    sg_role_id SERIAL,
    role_name TEXT NOT NULL,

    CONSTRAINT sg_role_pk PRIMARY KEY (role_id)
);

CREATE TABLE posts (
    sg_post_id SERIAL,
    author_id INTEGER REFERENCES users (sg_user_id),
    topic_song INTEGER REFERENCES songs (sg_song_id),
    topic_album INTEGER REFERENCES albums (album_id),
    topic_artist INTEGER REFERENCES artists (artist_id),
    content TEXT NOT NULL,

    CONSTRAINT sg_post_PK PRIMARY KEY (post_id)
);

CREATE TABLE replies (
    sg_reply_id SERIAL,
    parent INTEGER REFERENCES posts (sg_post_id),
    author INTEGER REFERENCES users (sg_user_id),
    content TEXT NOT NULL,

    CONSTRAINT sg_reply_PK PRIMARY KEY (re_id)
);

CREATE TABLE songs (
    sg_song_id SERIAL,
    song_title TEXT NOT NULL,
    album INTEGER REFERENCES albums (album_id),
    artist INTEGER REFERENCES artists (artist_id),
    video TEXT,
    audio_sample TEXT

    CONSTRAINT sg_song_PK PRIMARY KEY (song_id)
);

CREATE TABLE albums (
    album_id SERIAL,
    album_title TEXT NOT NULL,
    artist INTEGER NOT NULL,

    CONSTRAINT sg_album_PK PRIMARY KEY (album_id)
);

CREATE TABLE artists (
    artist_id SERIAL,
    artist_name TEXT NOT NULL
);