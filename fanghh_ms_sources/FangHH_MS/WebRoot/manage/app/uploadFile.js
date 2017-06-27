function uploadFile() {
	var path = $("#imageFile").val();
	if (path == null || path == '') {
		alert("文件路径不能为空");
		return;
	}
	else{
		alert(path);
	}
}