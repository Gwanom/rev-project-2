# This is the development branch for the backend

When working on the project:
- Create a new local branch on your machine that tracks your local dev branch
- After finishing work, commit only files that were changed
- Merge your branch back into your local dev
- Push commits from local/dev to remote/dev

## Endpoints:
- User Controller:
  - `/users`
    - GET: returns all users in the database <sup>A</sup>
  - `/users/renew`
    - POST: renews the JWT <sup>A</sup>
  - `/users/login`
    - POST: send a username and password in the body, receive a JWT if valid login
  - `/users/register`
    - POST: send a user object in the body, create a new user in the database if the username and email are unique
  
- Post Controller:
  - `/posts`
    - GET: returns all posts
  - `/posts/id/{postId}`
    - GET: returns the post with the given ID
  - `/posts/author/{userName}`
    - GET: returns all posts written by the given user
  - `/posts/song/{songTitle}`
    - GET: returns all posts that are "tagged" with the given song
  - `/posts/album/{album}`
    - GET: returns all posts that are "tagged" with the given album
  - `/posts/artist/{artist}`
    - GET: returns all posts that are "tagged" with the given artist
  
- Reply Controller:
  - `/replies`
    - GET: returns all replies
  - `/replies/parent/{postId}`
    - GET: returns all replies which are in response to a given post
  
- Artist Controller:
  - `/artists`
    - GET: returns all artists in the database
    - POST: add a new artist to the database
  - `/artists/name/{name}`
    - GET: returns the artist with the given name
  - `/artists/id/{id}`
    - GET: returns the artist with the given ID
  
- Album Controller:
  - `/albums`
    - GET: returns all albums
  - `/albums/title/{title}`
    - GET: returns the album with the given title
  - `/albums/id/{id}`
    - GET: returns the album with the given ID
  
- Song Controller:
  - `/songs`
    - GET: returns all songs
    - POST: add a new song to the database
  - `/songs/title/{title}`
    - GET: return the song with the given title
  - `/songs/id/{id}`
    - GET: return the song with the given ID
  
 A - Requires authentication
