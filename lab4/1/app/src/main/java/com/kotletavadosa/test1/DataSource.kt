package com.kotletavadosa.test1

import com.kotletavadosa.test1.models.BlogPost

class DataSource{

    companion object{

        fun createDataSet(): ArrayList<BlogPost>{
            val list = ArrayList<BlogPost>()
            list.add(
                BlogPost(
                    "Test 1",
                    "Test 1",
                    "https://aws1.discourse-cdn.com/nvidia/original/3X/8/3/8342beae8fa7dc56581a266d8752aa9bed9e9e58.png",
                    "Test User 1"
                )
            )
            list.add(
                BlogPost(
                    "Test 2",
                    "Test 2",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 2"
                )
            )

            list.add(
                BlogPost(
                    "Test 3",
                    "Test 3",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 3"
                )
            )
            list.add(
                BlogPost(
                    "Test 4",
                    "Test 4",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 4"
                )
            )
            list.add(
                BlogPost(
                    "Test 5",
                    "Test 5",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 5"
                )
            )
            list.add(
                BlogPost(
                    "Test 6",
                    "Test 6",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 6"
                )
            )
            list.add(
                BlogPost(
                    "Test 7",
                    "Test 7",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 7"
                )
            )
            list.add(
                BlogPost(
                    "Test 8",
                    "Test 8",
                    "https://citizengo.org/sites/default/files/images/test.png",
                    "Test User 8"
                )
            )
            list.add(
                BlogPost(
                    "Test 9",
                    "Test 9",
                    "https://aws1.discourse-cdn.com/nvidia/original/3X/8/3/8342beae8fa7dc56581a266d8752aa9bed9e9e58.png",
                    "Test User 9"
                )
            )
            return list
        }
    }
}