# Snowdog Android Recruitment Task

###To Do:
* move downloading data to Splash screen instead of MainActivity
* cache api data
* restructure files to MVP pattern
* Download albums from the endpoint [`/albums/{id}`](https://jsonplaceholder.typicode.com/albums/2) for `ids` that are in the downloaded photos (field: `albumId`). You can use `RawAlbum` model.
* Download users from the endpoint [`/users/{id}`](https://jsonplaceholder.typicode.com/users/3) for `ids` that are in the downloaded albums (field: `userId`). You can use `RawUser` model.
* check internet connection
* display details on details screen
* use `R.id.search` to filter data by `title` and `albumTitle` in `RecyclerView`.
* style app using colors
* create some animations/transitions


### Demo:

![Demo][demo]

[demo]: art/demo.gif
