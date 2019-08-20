function showPic() {//1.当用户上传图片后，触发input标签的onchange事件，执行showPic()
    var fileObj = document.getElementById("file");
    var showimageObj = document.getElementById("showimage");
    showimageObj.innerHTML = "";
    var fileList = fileObj.files;
    for (var i = 0; i < fileList.length; i++) {
        showimageObj.innerHTML += "<div style='float:left' > <img id='img" + i + "'  /> </div>";
        var imgObjPreview = document.getElementById("img"+i);
        if (fileObj.files && fileObj.files[i]) {
            //非IE，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '150px';
            imgObjPreview.style.height = '180px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(fileObj.files[i]);
            // window.URL.createObjectURL(fileObj.files[i]);
        }
        else {
            //IE下，使用滤镜
            fileObj.select();
            var imgSrc = document.selection.createRange().text;
            alert(imgSrc)
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "150px";
            localImagId.style.height = "180px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            }
            catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
    }
    return true;
}