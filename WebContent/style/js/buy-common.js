/* @update: 2014-11-20 16:19:19 */
function login() {
    return location.href = "https://passport.jd.com/new/login.aspx?ReturnUrl=" + escape(location.href).replace(/\//g, "%2F"),
    !1
}
function regist() {
    return location.href = "https://reg.jd.com/reg/person?ReturnUrl=" + escape(location.href),
    !1
}
function createCookie(t, e, i, n) {
    var n = n ? n: "/";
    if (i) {
        var s = new Date;
        s.setTime(s.getTime() + 24 * i * 60 * 60 * 1e3);
        var a = "; expires=" + s.toGMTString()
    } else var a = "";
    document.cookie = t + "=" + e + a + "; path=" + n
}
function readCookie(t) {
    for (var e = t + "=",
    i = document.cookie.split(";"), n = 0; n < i.length; n++) {
        for (var s = i[n];
        " " == s.charAt(0);) s = s.substring(1, s.length);
        if (0 == s.indexOf(e)) return s.substring(e.length, s.length)
    }
    return null
}
function checkLogin() {
    var t = "https:" === window.location.protocol ? "https:": "http:",
    e = t + "//passport.jd.com/call/getHelloJson?m=ls";
    jQuery.ajax({
        url: e,
        dataType: "jsonp",
        scriptCharset: "gb2312",
        success: function(t) {
            t && t.info && $("#loginbar").html(t.info),
            t && t.sso && $.each(t.sso,
            function() {
                jQuery.getJSON(this)
            })
        }
    })
}
function userGuide() {
    var t = "1" === readCookie("cashierUsedBank") ? !1 : !0,
    e = "1" === readCookie("cashierAllBank") ? !1 : !0,
    i = '<div class="ui-tips ui-tips-red"><span class="ui-tips-wrap"><i class="ui-tips-arrow"></i><span class="ui-tips-text">${text}</span></span></div>';
    if (t) {
        var n = function() {
            if (0 !== $(this).find(".ub-arrow:visible").length) {
                var t = $(this).find(".ub-arrow"),
                e = t.offset().top,
                n = t.offset().left,
                s = $(i.replace("${text}", "\u70b9\u51fb\u67e5\u770b\u60a8\u5e38\u7528\u94f6\u884c\u5361"));
                s.css({
                    left: n - 108,
                    top: e + 30
                }).attr("id", "J_usedPayCardTips"),
                s.find(".ui-tips-arrow").css({
                    left: "auto",
                    right: 10
                }),
                $("body").append(s)
            }
        },
        s = function() {
            $("#J_usedPayCardTips").remove()
        };
        $("#payCardBoxDiv").bind("mouseover", n).bind("mouseout", s),
        $(".j_usedBankSelect").bind("click",
        function() {
            $("#J_usedPayCardTips").remove(),
            $("#payCardBoxDiv").unbind("mouseover", n).unbind("mouseout", s),
            createCookie("cashierUsedBank", "1", 3650)
        })
    }
    if (e) {
        var a = function() {
            if (0 !== $(this).find(".j_usedBankSelect:visible").length) {
                var t = $(this).find(".bank-new"),
                e = t.offset().top,
                n = t.offset().left,
                s = $(i.replace("${text}", "\u70b9\u51fb\u67e5\u770b\u6240\u6709\u94f6\u884c"));
                s.css({
                    left: n,
                    top: e + 32
                }).attr("id", "J_payCardTips"),
                $("body").append(s)
            }
        },
        o = function() {
            $("#J_payCardTips").remove()
        };
        $("#payCardBoxDiv").bind("mouseover", a).bind("mouseout", o),
        $(".bank-new").bind("click",
        function() {
            $("#J_payCardTips").remove(),
            $("#payCardBoxDiv").unbind("mouseover", a).unbind("mouseout", o),
            createCookie("cashierAllBank", "1", 3650)
        })
    }
}
checkLogin(),
function($) {
    $.fn.Jtab = function(t, e) {
        if (this.length) {
            "function" == typeof t && (e = t, t = {});
            var i = $.extend({
                type: "static",
                auto: !1,
                event: "mouseover",
                currClass: "curr",
                source: "data-tag",
                hookKey: "data-widget",
                hookItemVal: "tab-item",
                hookContentVal: "tab-content",
                stay: 5e3,
                delay: 100,
                threshold: null,
                mainTimer: null,
                subTimer: null,
                index: 0,
                compatible: !1
            },
            t || {}),
            n = $(this).find("*[" + i.hookKey + "=" + i.hookItemVal + "]"),
            s = $(this).find("*[" + i.hookKey + "=" + i.hookContentVal + "]"),
            a = i.source.toLowerCase().match(/http:\/\/|\d|\.aspx|\.ascx|\.asp|\.php|\.html\.htm|.shtml|.js/g);
            if (n.length != s.length) return ! 1;
            var o = function(t, e) {
                i.subTimer = setTimeout(function() {
                    n.eq(i.index).removeClass(i.currClass),
                    i.compatible && s.eq(i.index).hide(),
                    e ? (i.index++, i.index == n.length && (i.index = 0)) : i.index = t,
                    i.type = null != n.eq(i.index).attr(i.source) ? "dynamic": "static",
                    l()
                },
                i.delay)
            },
            r = function() {
                i.mainTimer = setInterval(function() {
                    o(i.index, !0)
                },
                i.stay)
            },
            l = function() {
                switch (n.eq(i.index).addClass(i.currClass), i.compatible && s.eq(i.index).show(), i.type) {
                default:
                case "static":
                    var t = "";
                    break;
                case "dynamic":
                    var t = a ? i.source: n.eq(i.index).attr(i.source);
                    n.eq(i.index).removeAttr(i.source)
                }
                e && e(t, s.eq(i.index), i.index)
            };
            n.each(function(t) {
                $(this).bind(i.event,
                function() {
                    clearTimeout(i.subTimer),
                    clearInterval(i.mainTimer),
                    o(t, !1)
                }).bind("mouseleave",
                function() {
                    i.auto && r()
                })
            }),
            "dynamic" == i.type && o(i.index, !1),
            i.auto && r()
        }
    }
} (jQuery),
jQuery.extend(jQuery.easing, {
    def: "easeOutQuad",
    easeInQuint: function(t, e, i, n, s) {
        return n * (e /= s) * e * e * e * e + i
    },
    easeOutQuint: function(t, e, i, n, s) {
        return n * ((e = e / s - 1) * e * e * e * e + 1) + i
    },
    easeInOutQuint: function(t, e, i, n, s) {
        return (e /= s / 2) < 1 ? n / 2 * e * e * e * e * e + i: n / 2 * ((e -= 2) * e * e * e * e + 2) + i
    },
    easeOutElastic: function(t, e, i, n, s) {
        var a = 1.70158,
        o = 0,
        r = n;
        if (0 == e) return i;
        if (1 == (e /= s)) return i + n;
        if (o || (o = .3 * s), r < Math.abs(n)) {
            r = n;
            var a = o / 4
        } else var a = o / (2 * Math.PI) * Math.asin(n / r);
        return r * Math.pow(2, -10 * e) * Math.sin(2 * (e * s - a) * Math.PI / o) + n + i
    },
    easeInOutElastic: function(t, e, i, n, s) {
        var a = 1.70158,
        o = 0,
        r = n;
        if (0 == e) return i;
        if (2 == (e /= s / 2)) return i + n;
        if (o || (o = .3 * s * 1.5), r < Math.abs(n)) {
            r = n;
            var a = o / 4
        } else var a = o / (2 * Math.PI) * Math.asin(n / r);
        return 1 > e ? -.5 * r * Math.pow(2, 10 * (e -= 1)) * Math.sin(2 * (e * s - a) * Math.PI / o) + i: r * Math.pow(2, -10 * (e -= 1)) * Math.sin(2 * (e * s - a) * Math.PI / o) * .5 + n + i
    },
    easeInCirc: function(t, e, i, n, s) {
        return - n * (Math.sqrt(1 - (e /= s) * e) - 1) + i
    },
    easeOutCirc: function(t, e, i, n, s) {
        return n * Math.sqrt(1 - (e = e / s - 1) * e) + i
    },
    easeInOutCirc: function(t, e, i, n, s) {
        return (e /= s / 2) < 1 ? -n / 2 * (Math.sqrt(1 - e * e) - 1) + i: n / 2 * (Math.sqrt(1 - (e -= 2) * e) + 1) + i
    }
});
var paymentUI = {};
paymentUI.init = function() {
    this.setPayboxHover(),
    this.setPayCheckHover(),
    this.setNoticeClose(),
    this.setBankMore(),
    this.setTips(),
    this.setPop(),
    this.setPayItmeHover(),
    this.setPlaceholder(),
    this.setFenqiPop(),
    this.setBaozhangPop(),
    this.setMagnifying(),
    this.preloadImg(),
    this.qrCoderImg()
},
paymentUI.setPayboxHover = function() {
    var t = $(".j_paybox");
    t.live("mouseenter",
    function() {
        $(this).hasClass("paybox-disable") || $(this).addClass("paybox-hover")
    }).live("mouseleave",
    function() {
        $(this).hasClass("paybox-disable") || $(this).removeClass("paybox-hover")
    })
},
paymentUI.setPayItmeHover = function() {
    var t = $(".pl-item");
    t.live("mouseenter",
    function() {
        $(this).addClass("hover")
    }).live("mouseleave",
    function() {
        $(this).removeClass("hover")
    })
},
paymentUI.setPayCheckHover = function() {
    $(".p-k-check").live("mouseenter",
    function() {
        $(this).hasClass("ui-check-disable") || $(this).find(".j_paymentCheck").addClass("ui-checkbox-L-hover")
    }).live("mouseleave",
    function() {
        $(this).hasClass("ui-check-disable") || $(this).find(".j_paymentCheck").removeClass("ui-checkbox-L-hover")
    })
},
paymentUI.setNoticeClose = function() {
    $(".j_cnClose").bind("click",
    function() {
        $(this).parents(".cashier-notice").hide()
    })
},
paymentUI.showModal = function(t, e) {
    var e = "undefined" != typeof e ? e: function() {},
    i = $(window).scrollTop(),
    n = $('<div class="ui-modal-mask"></div>'),
    s = $(t),
    a = $(".shortcut, .p-header, .main, .p-footer");
    $("body").append(n),
    a.addClass("ui-modal-mask-blur");
    var o = $(window).height() / 2 - s.height() / 2;
    o = 0 >= o ? 0 : o,
    s.css({
        top: i + o
    }).show(),
    e(),
    s.find(".um-h-close").unbind(),
    s.find(".um-h-close").bind("click",
    function() {
        s.hide(),
        n.remove(),
        a.removeClass("ui-modal-mask-blur")
    })
},
paymentUI.setBankMore = function() {
    $(".j_showBankMore").bind("click",
    function() {
        $(this).siblings(".hide").show(),
        $(this).hide();
        var t = $(this).parents(".payment-list").find(".bw-more-unionpay");
        0 !== t.length && t.show()
    })
},
paymentUI.setAuthCountdown = function(t, e, i) {
    var n = this,
    s = $(t);
    e = "undefined" != typeof e ? e: 60,
    i = "undefined" != typeof i ? i: function() {},
    this.setAuthCountdown.time = e,
    this.setAuthCountdown.timer = setInterval(function() {
        var t = n.setAuthCountdown.time;
        s.html(t),
        0 >= t && (i(), clearInterval(n.setAuthCountdown.timer)),
        n.setAuthCountdown.time--
    },
    1e3)
},
paymentUI.setOrderCountdown = function(t, e, i) {
    var n = this,
    s = $(t);
    e = "undefined" != typeof e ? e: 60,
    i = "undefined" != typeof i ? i: function() {};
    var a = function(t, e) {
        return (t / Math.pow(10, e)).toFixed(e).substr(2)
    },
    o = function(t) {
        var e = Math.floor(t / 86400),
        i = Math.floor(t % 86400 / 3600),
        n = Math.floor(t % 86400 % 3600 / 60),
        t = t % 86400 % 3600 % 60;
        return {
            d: e,
            h: a(i, 2),
            m: a(n, 2),
            s: a(t, 2)
        }
    };
    this.setOrderCountdown.time = e,
    this.setOrderCountdown.timer = setInterval(function() {
        var t = n.setOrderCountdown.time,
        e = o(t),
        a = e.h + ":" + e.m + ":" + e.s;
        s.html(a),
        0 >= t && (i(), clearInterval(n.setOrderCountdown.timer)),
        n.setOrderCountdown.time--
    },
    1e3)
},
paymentUI.setTips = function() {
    var t = $(".j_uiTips"),
    e = '<div class="ui-tips"><i class="ui-tips-fill"></i><span class="ui-tips-wrap"><i class="ui-tips-arrow"></i><span class="ui-tips-text">${text}</span></span></div>';
    t.live("mouseenter",
    function() {
        var t = $(this).width(),
        i = t / 2,
        n = $(this).height() + 6,
        s = $(this).offset().top,
        a = $(this).offset().left,
        o = $(this).attr("data-tips");
        $(".ui-tips").remove();
        var r = $(e.replace("${text}", o));
        r.css({
            left: a + i - 26,
            top: s + n
        }),
        r.find(".ui-tips-fill").css({
            position: "absolute",
            display: "block",
            width: t,
            height: n,
            left: a - (a + i - 26),
            top: -n
        });
        var l = 0;
        r.bind("mouseleave",
        function() {
            var t = this;
            l = setTimeout(function() {
                $(t).remove()
            },
            300)
        }),
        r.bind("mouseenter",
        function() {
            clearTimeout(l)
        }),
        $("body").append(r)
    })
},
paymentUI.setPop = function() {
    var t = ".j_uiPop",
    e = $(t),
    i = ".j_uiPopClose";
    e.bind("mouseenter",
    function() {
        $(this).addClass("hover")
    }).bind("mouseleave",
    function() {
        $(this).removeClass("hover")
    }),
    e.find(i).bind("click",
    function() {
        $(this).parents(t).removeClass("hover")
    })
},
paymentUI.setPaidPop = function(t) {
    var t = t ? t: function() {},
    e = ".j_uiPaidPop",
    i = $(e),
    n = this;
    i.live("mouseenter",
    function() {
        var e = n.renderPop({
            targetElement: i,
            leftFix: 0,
            width: 150,
            wrapClass: "ui-pop-paid",
            htmlTitle: i.html(),
            htmlContent: "&nbsp;",
            hasClose: !0
        });
        e.find(".ui-pop-content").addClass("loading"),
        $("body").append(e),
        t(e)
    })
},
paymentUI.setBaozhangPop = function() {
    var t = ".j_uiBaozhangPop",
    e = $(t),
    i = this;
    e.live("mouseenter",
    function() {
        var t = i.renderPop({
            targetElement: $(this),
            leftFix: -200,
            width: 500,
            wrapClass: "ui-pop-baozhang",
            htmlTitle: "\u8be5\u8ba2\u5355\u4e2d\u542b\u7b2c\u4e09\u65b9\u5356\u5bb6\u63d0\u4f9b\u5e76\u9700\u5728\u7ebf\u652f\u4ed8\u7684\u5546\u54c1\uff0c\u4eac\u4e1c\u5c06\u4fdd\u969c\u60a8\u5df2\u652f\u4ed8\u7684\u8d44\u91d1\u5b89\u5168\u3002",
            htmlContent: '<i class="baozhang-img"></i>',
            hasClose: !1
        });
        $("body").append(t)
    })
},
paymentUI.setFenqiPop = function() {
    var t = ".j_uiFenqiPop",
    e = $(t),
    i = this,
    n = function(t) {
        return new Function("return" + t)()
    },
    s = '<table><colgroup><col width="140"><col width=""><col width=""></colgroup><thead><tr><th>\u652f\u4ed8\u65b9\u5f0f</th><th>\u5206\u671f\u8d39\u7528</th><th>\u6bcf\u671f\u8d39\u7387</th></tr></thead><tbody><tr class="tr-baitiao"><td>\u4eac\u4e1c\u767d\u6761</td><td>{btCost}\u5143</td><td>{btRate}</td></tr><tr><td>\u4fe1\u7528\u5361<span class="font-gray">\uff08\u5e73\u5747\u6c34\u5e73\uff09</span></td><td>{crCost}\u5143</td><td>{crRate}</td></tr></tbody></table>';
    e.live("mouseenter",
    function() {
        if ("undefined" != typeof $(this).attr("data-save")) {
            var t = n($(this).attr("data-save")),
            e = s.replace("{btCost}", t.btCost);
            e = e.replace("{btRate}", t.btRate),
            e = e.replace("{crCost}", t.crCost),
            e = e.replace("{crRate}", t.crRate);
            var a = i.renderPop({
                targetElement: $(this),
                leftFix: -80,
                htmlTitle: '\u5df2\u4e3a\u60a8\u8282\u7701\u5206\u671f\u8d39\u7528<span class="font-red">' + t.save + "</span>\u5143",
                htmlContent: e
            });
            $("body").append(a)
        }
    })
},
paymentUI.renderPop = function(t) {
    var e = {
        targetElement: t.targetElement ? t.targetElement: $("body"),
        leftFix: t.leftFix ? t.leftFix: 0,
        topFix: t.topFix ? t.topFix: 0,
        hasClose: "undefined" != typeof t.hasClose ? t.hasClose: !0,
        htmlTitle: t.htmlTitle ? t.htmlTitle: "\u5f39\u6846",
        htmlContent: t.htmlContent ? t.htmlContent: "\u5185\u5bb9",
        wrapClass: t.wrapClass ? t.wrapClass: "",
        width: t.width ? t.width: 315
    };
    $targetElement = e.targetElement;
    var i = '<a class="ui-pop-close j_uiPopClose" href="javascript:;"></a><div class="ui-pop-title">' + e.htmlTitle + '</div><div class="ui-pop-content">' + e.htmlContent + "</div>",
    n = $('<div class="ui-pop ' + e.wrapClass + '"></div>');
    n.html(i);
    var s = $targetElement.height(),
    a = $targetElement.offset().top,
    o = $targetElement.offset().left;
    n.css({
        left: o + e.leftFix,
        top: a + s + e.topFix,
        width: e.width
    }),
    e.hasClose ? n.find(".j_uiPopClose").bind("click",
    function() {
        n.remove()
    }) : n.find(".j_uiPopClose").remove();
    var r = $targetElement.attr("class"),
    l = function(t) {
        $(t.target).hasClass(r) || $(t.target).hasClass("ui-pop") || 0 !== $(t.target).parents(".ui-pop").length || (n.remove(), $("body").unbind("mouseover", l))
    };
    return $("body").bind("mouseover",
    function(t) {
        l(t)
    }),
    $(".ui-pop").remove(),
    n
},
paymentUI.setPlaceholder = function() {
    var t = "placeholder" in document.createElement("input");
    if (!t) {
        var e = $(".ui-input, .bi-i-text"),
        i = "placeholder";
        e.each(function() {
            if ("undefined" != typeof $(this).attr("placeholder")) {
                var t = $.trim($(this).attr("placeholder")),
                e = $.trim($(this).val()),
                n = "password" === $(this).attr("type") ? !0 : !1,
                s = function(e) {
                    var n = $(e),
                    s = $(e).siblings(".placeholder-ie-fix");
                    0 !== s.length && s.remove(),
                    n.hide();
                    var a = $('<input type="text" />');
                    a.attr({
                        "class": "placeholder-ie-fix " + n.attr("class")
                    }),
                    $(e).after(a),
                    a.addClass(i).val(t),
                    a.bind("focus",
                    function() {
                        a.remove(),
                        n.show(),
                        n.focus()
                    })
                }; (0 === $.trim($(this).val()).length || e === t) && (n ? s(this) : $(this).addClass(i).val(t)),
                $(this).bind("focus",
                function() {
                    $(this).hasClass(i) && $(this).removeClass(i).val("")
                }).bind("blur",
                function() {
                    if (0 === $.trim($(this).val()).length) {
                        var t = $(this).attr(i);
                        n ? s(this) : $(this).addClass(i).val(t)
                    }
                })
            }
        })
    }
},
paymentUI.setMagnifying = function() {
    var t = ".j_uiMagnifying",
    e = $(t),
    i = function(e) {
        $input = e;
        var i = 0 !== $input.parents(t).length ? $input.parents(t) : $input,
        n = i.outerWidth(),
        s = i.outerHeight(!0),
        a = i.offset().top,
        o = i.offset().left,
        r = $('<div class="ui-magnifying"></div>'),
        l = '<span class="ui-magnifying-wrap"><span class="ui-magnifying-text"></span></span>';
        r.css({
            width: n,
            left: o,
            top: a + s - 1
        }).html(l);
        var u = $input.val().toUpperCase();
        if (r.find(".ui-magnifying-text").html(u), r.appendTo("body"), $.browser.msie && "6.0" === $.browser.version) {
            var h = $('<iframe class="ui-magnifying-iframe" frameBorder="0"></iframe>');
            h.css({
                width: n,
                height: 32,
                left: o,
                top: a + s - 1
            }),
            h.appendTo("body")
        }
    };
    e.each(function() {
        var e = 0 !== $(this).find(".bi-i-text").length ? $(this).find(".bi-i-text") : $(this);
        e.bind("focus",
        function() {
            0 !== $.trim($(this).val()).length && i($(this))
        }),
        e.bind("keyup",
        function() {
            if (0 === $(".ui-magnifying").length) i($(this));
            else {
                var e = 0 !== $(this).parents(t).length ? $(this).parents(t) : $(this),
                n = e.offset().left;
                $(".ui-magnifying").css({
                    left: n
                });
                var s = $(this).val().toUpperCase();
                $(".ui-magnifying").find(".ui-magnifying-text").html(s)
            }
        }),
        e.bind("blur",
        function() {
            $(".ui-magnifying, .ui-magnifying-iframe").remove()
        })
    })
},
paymentUI.preloadImg = function() {
    for (var t = "https:" === window.location.protocol ? "https:": "http:", e = ["css/i/pay-credit-bg-code.gif", "css/i/pay-credit-bg-month.gif", "css/i/pay-credit-bg-verify.gif", "css/i/pay-credit-bg-year.gif", "css/i/ui-button-XL-loading.gif"], i = 0; i < e.length; i++) {
        var n = new Image;
        n.setAttribute("src", t + "//sp.jd.com/payment/1.0.0/" + e[i])
    }
},
paymentUI.qrCoderImg = function() {
    $(".o-qrcode").bind("mouseenter",
    function() {
        $(this).addClass("o-qrcode-hover")
    }).bind("mouseleave",
    function() {
        $(this).removeClass("o-qrcode-hover")
    })
},
$(function() {
    paymentUI.init(),
    userGuide()
});