

//document.getElementById("picture_frame").addEventListener("click", rollThroughPictures());



function rollThroughPictures(picture_array) {
    
    document.getElementById('picture_frame').src = picture_array[0];
    var current_picture = document.getElementById("picture_frame").src.split('/');
    var index = picture_array.indexOf("automobile_images/" + current_picture[current_picture.length -1]);

    if (index == picture_array.length - 1) {
        index = -1;
    }

    index = index + 1;
    document.getElementById("picture_frame").src = picture_array[index];
}


function sliderDisplayValue() {
    var miles = document.getElementById('slider').value;
    document.getElementById('display').innerText = miles + ",000 miles";
}
