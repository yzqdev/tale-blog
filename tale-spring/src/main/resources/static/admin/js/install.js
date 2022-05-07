/**
 * Created by biezhi on 2017/2/23.
 */
!function ($) {

    "use strict";
    let tale = new $.tale();
    let FormWizard = function () {
    };
    //creates form with validation
    FormWizard.prototype.init = function () {
        let $form_container = $("#wizard-validation-form");
        $form_container.validate({
            errorPlacement: function errorPlacement(error, element) {
                element.after(error);
            }
        });
        $form_container.children("div").steps({
            headerTag: "h3",
            bodyTag: "section",
            transitionEffect: "slideLeft",
            labels: {
                previous: "上一步",
                next: "下一步",
                finish: "登录后台",
                loading: '加载中...',
                current: '当前位置'
            },
            onStepChanging: function (event, currentIndex, newIndex) {
                tale.showLoading();
                $form_container.validate().settings.ignore = ":disabled,:hidden";
                if(currentIndex === 1 && newIndex === 0){
                    return true;
                }
                let isValid = $form_container.valid();
                if(!isValid){
                    tale.hideLoading();
                }
                if (isValid && currentIndex === 0) {
                    isValid = false;
                    let params = $form_container.serialize();
                    tale.showLoading();
                    $.ajax({
                        url: '/home/install',
                        type: 'POST',
                        async: false,
                        data: params,
                        dataType: 'json',
                        success: function (result) {
                            console.log('result==>'+result)
                            console.log(result)

                            if (result && result.success) {
                                isValid = true;
                            } else {
                                if (result.msg) {
                                    tale.alertError(result.msg || '安装失败');
                                }
                            }
                        },
                        error: function (e) {
                            console.log('post异常', e);
                        }
                    });
                    return isValid;
                } else {
                    return isValid;
                }
            },
            onStepChanged: function (event, currentIndex) {
                tale.hideLoading();
            },
            onFinishing: function (event, currentIndex) {
                $form_container.validate().settings.ignore = ":disabled";
                let isValid = $form_container.valid();
                window.location.href = "/admin/login";
                return isValid;
            },
            onFinished: function (event, currentIndex) {
                window.location.href = "/admin/login";
            }
        });
        return $form_container;
    },
        //init
        $.FormWizard = new FormWizard, $.FormWizard.Constructor = FormWizard
}(window.jQuery), $.FormWizard.init();
let siteUrl = document.location.protocol + '//' + document.location.host;
let el = document.getElementById('siteUrl');
// noinspection JSAnnotator
if(el){
    el.value = siteUrl;
}