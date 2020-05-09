function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    if (!content) {
        alert("回复内容不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                window.location.reload();
                // $("#comment_section").hide()
            } else if (response.code === 2003) {
                var isAccepted = confirm(response.message);
                if (isAccepted) {
                    //跳转登录页面
                    window.open("https://github.com/login/oauth/authorize?client_id=1cdd13b1b9be4b550480&redirect_uri=http://localhost:8080/callback&scope=user&state=1")
                    //将closable 状态放置到localStorage
                    window.localStorage.setItem("closable", true);
                }

            } else {
                alert("提交失败:" + response.message);
            }

        }
    });
}