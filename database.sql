SET SCHEMA 'spotigram';
CREATE TABLE roles (
	id SERIAL PRIMARY KEY,
	roleName TEXT NOT NULL
);

CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	username TEXT NOT NULL UNIQUE,
	password TEXT NOT NULL,
	firstName TEXT NOT NULL,
	lastName TEXT NOT NULL,
	email TEXT NOT NULL UNIQUE,
	userRole INTEGER REFERENCES roles (id),
	isBanned BOOLEAN NOT NULL
);

CREATE TABLE album (
	id SERIAL PRIMARY KEY,
	title TEXT NOT NULL
);

CREATE TABLE artist (
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL
);

CREATE TABLE song (
	id SERIAL PRIMARY KEY,
	title TEXT NOT NULL,
	album INTEGER REFERENCES album (id),
	artist INTEGER REFERENCES artist (id),
	video TEXT,
	sample TEXT
);

CREATE TABLE post (
	id SERIAL PRIMARY KEY,
	author INTEGER REFERENCES users (id),
	topicSong INTEGER REFERENCES song (id),
	topicAlbum INTEGER REFERENCES album (id),
	topicArtist INTEGER REFERENCES artist (id),
	topicContent TEXT NOT NULL
);

CREATE TABLE reply (
	id SERIAL PRIMARY KEY,
	parentPost INTEGER REFERENCES post (id),
	author INTEGER REFERENCES users (id),
	replyContent TEXT NOT NULL
);
