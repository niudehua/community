/**
 * 提交问题评论
 */
function post() {
    const questionId = $("#question_id").val();
    const content = $("#comment_content").val();
    comment2target(questionId, content, 1)
}

/**
 * 提交评论的回复
 * @param e
 */
function comment(e) {
    const commentId = e.getAttribute("data-id");
    const content = $("#input-" + commentId).val();
    comment2target(commentId, content, 2)

}

/**
 * 提交评论到后台
 * @param targetId parentId
 * @param content  评论内容
 * @param type  类型
 */
function comment2target(targetId, content, type) {
    if (!content) {
        alert("回复内容不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        dataType: "json",
        success: function (response) {
            if (response.code === 200) {
                window.location.reload();
                // $("#comment_section").hide()
            } else if (response.code === 2003) {
                const isAccepted = confirm(response.message);
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

/**
 * 展开二级回复
 */
function collapseComment(e) {
    const id = e.getAttribute("data-id");
    const subCommentContainer = $("#comment-" + id);

    if (subCommentContainer.hasClass("in")) {
        subCommentContainer.toggleClass("in");
        $("#sub_comment_icon-" + id).toggleClass("sub-comment-icon-active");
    } else {
        if (subCommentContainer.children().length === 1) {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {

                    const mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img alt='网络头像' src='#'/>", {
                        "class": "media-object img_avatar_url",
                        "src": comment.user.avatarUrl
                    }));

                    const mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "text-desc",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<span/>", {
                        "class": "pull-right text-desc",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    }));

                    const mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    subCommentContainer.prepend(mediaElement);
                });

            });
            subCommentContainer.toggleClass("in");
            $("#sub_comment_icon-" + id).toggleClass("sub-comment-icon-active");
        } else {
            subCommentContainer.toggleClass("in");
            $("#sub_comment_icon-" + id).toggleClass("sub-comment-icon-active");
        }

    }
}

