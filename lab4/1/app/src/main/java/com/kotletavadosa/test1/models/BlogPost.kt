package com.kotletavadosa.test1.models

data class BlogPost(

    var postTitle: String,

    var postBody: String,

    var postImage: String,

    var username: String


) {

    override fun toString(): String {
        return "BlogPost(title='$postTitle', image='$postImage', username='$username')"
    }


}
























