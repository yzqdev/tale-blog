package com.yzq.talespring.model.dto;

/**
 * Types
 *
 * Created by biezhi on 2017/2/21.
 */
public interface Types {

    String TAG = "tag";
    String CATEGORY = "category";
    String ARTICLE = "post";
    String PUBLISH = "publish";
    String PAGE = "page";
    String DRAFT = "draft";
    String IMAGE = "image";
    String FILE = "file";
    String COMMENTS_FREQUENCY = "comments:frequency";

    String RECENT_ARTICLE = "recent_article";
    String RANDOM_ARTICLE = "random_article";

    String RECENT_META = "recent_meta";
    String RANDOM_META = "random_meta";

    String SYS_STATISTICS = "sys:statistics";

    String NEXT = "next";
    String PREV = "prev";

    /**
     * 附件存放的URL，默认为网站地址，如集成第三方则为第三方CDN域名
     */
    String ATTACH_URL = "attach_url";
    String CDN_URL = "cdn_url";

    /**
     * 网站要过滤，禁止访问的ip列表
     */
    String BLOCK_IPS = "site_block_ips";

}
