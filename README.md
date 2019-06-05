# pyramidweb
##  build and start
This project demonstrates how the `openseadragon` package can be used with webpack.

Clone the project.

    git clone https://github.com/yangdengxian/pyramidweb.git

Install the project dependencies.

    cd high-image-view
    mvn install

Create a bundle for the browser.

    mvn build

Start the project

    mvn start


-----

## branchs description
**v1.0.0**

> * readDZIImage
> * writeDZIImage

**v1.1.0**

> * create fileserver
> * static files configuration

#### How to config static files path in spring boot
###### https://blog.csdn.net/yu514950381/article/details/78015088
###### https://spring.io/blog/2013/12/19/serving-static-web-content-with-spring-boot

## dependencies
**dependencies**
[pyramidio][1]
[spring-boot][2]



  [1]: https://github.com/usnistgov/pyramidio
  [2]: https://spring.io/projects/spring-boot

  
## description
###### This project depends `pyramidio`, if you are interested to the native codes, read them on github, please.

###### This is only a web example implemented in pure java and srping-boot. If you want to look at the tiles pictures,  there is a another project for JavaScript([high-image-view](https://github.com/yangdengxian/high-image-view.git "high-image-view")) to help you with viewing the tiles. Remember it, all of them will be start at the same time.
