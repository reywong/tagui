<%--
  Created by IntelliJ IDEA.
  User: reywong
  Date: 2017/8/1
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(document).ready(function () {
        // Open close small chat
        $('.open-small-chat').click(function () {
            $(this).children().toggleClass('fa-comments').toggleClass('fa-remove');
            $('.small-chat-box').toggleClass('active');
        });

        // Initialize slimscroll for small chat
        $('.small-chat-box .content').slimScroll({
            height: '234px',
            railOpacity: 0.4
        });

    });

</script>
<div class="small-chat-box fadeInRight animated">

    <div class="heading" draggable="true">
        <small class="chat-date pull-right">
            02.19.2015
        </small>
        Small chat
    </div>

    <div class="content">

        <div class="left">
            <div class="author-name">
                Monica Jackson
                <small class="chat-date">
                    10:02 am
                </small>
            </div>
            <div class="chat-message active">
                Lorem Ipsum is simply dummy text input.
            </div>

        </div>
        <div class="right">
            <div class="author-name">
                Mick Smith
                <small class="chat-date">
                    11:24 am
                </small>
            </div>
            <div class="chat-message">
                Lorem Ipsum is simpl.
            </div>
        </div>
        <div class="left">
            <div class="author-name">
                Alice Novak
                <small class="chat-date">
                    08:45 pm
                </small>
            </div>
            <div class="chat-message active">
                Check this stock char.
            </div>
        </div>
        <div class="right">
            <div class="author-name">
                Anna Lamson
                <small class="chat-date">
                    11:24 am
                </small>
            </div>
            <div class="chat-message">
                The standard chunk of Lorem Ipsum
            </div>
        </div>
        <div class="left">
            <div class="author-name">
                Mick Lane
                <small class="chat-date">
                    08:45 pm
                </small>
            </div>
            <div class="chat-message active">
                I belive that. Lorem Ipsum is simply dummy text.
            </div>
        </div>


    </div>
    <div class="form-chat">
        <div class="input-group input-group-sm"><input type="text" class="form-control"> <span class="input-group-btn"> <button
                class="btn btn-primary" type="button">Send
        </button> </span></div>
    </div>

</div>
<div id="small-chat">

    <span class="badge badge-warning pull-right">5</span>
    <a class="open-small-chat">
        <i class="fa fa-comments"></i>

    </a>
</div>