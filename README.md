# Snowdog Android Recruitment Task
![Demo][logo]

## Technologies
Kotlin
- ext.kotlin_version = '1.3.61'
SDK
- compileSdkVersion 29
- minSdkVersion 21
- targetSdkVersion 29

### Used Libraries
- Retrofit 2
- Gson
- Glide
- Dagger
- Timber
- Threeten
- Room


### To Do:
* move downloading data to Splash screen instead of MainActivity
* limit results to 100 on one page
* cache api data in Splash
* restructure files to MVP pattern
* Download albums from the endpoint [`/albums/{id}`](https://jsonplaceholder.typicode.com/albums/2) for `ids` that are in the downloaded photos (field: `albumId`). You can use `RawAlbum` model.
* Download users from the endpoint [`/users/{id}`](https://jsonplaceholder.typicode.com/users/3) for `ids` that are in the downloaded albums (field: `userId`). You can use `RawUser` model.
* filter data by name
* check internet connection on MainActivity
* display details on details screen
* limit results to 100 on one page
* use `R.id.search` to filter data by `title` and `albumTitle` in `RecyclerView`.
* style app using colors
* create some animations/transitions
* change progressbar style
* change icon to be without Debug annotation
* show album names instead of albumId
* Tests

### Original Demo:

![Demo][demo]

[demo]: art/demo.gif
[logo]: art/logo