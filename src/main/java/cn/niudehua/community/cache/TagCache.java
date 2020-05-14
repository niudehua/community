package cn.niudehua.community.cache;

import cn.niudehua.community.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/5/14 9:59 上午
 * @desc: 标签缓存
 */
public class TagCache {
    public static List<TagDTO> getTagCache() {
        List<TagDTO> tagCache = new ArrayList<>();
        // 开发语言类
        TagDTO program = new TagDTO();
        program.setTagCategory("开发语言");
        program.setTags(Arrays.asList("javascript", "php", "css", "html", "html5", "java", "node.js", "python" + "c++", "c", "golang", "objective-c", "typescript", "shell", "swift", "c#", "sass", "ruby", "bash", "less", "asp.net", "lua", "scala", "coffeescript", "actionscript", "rust", "erlang", "perl"));
        tagCache.add(program);

        // 平台框架类
        TagDTO framework = new TagDTO();
        framework.setTagCategory("平台框架");
        framework.setTags(Arrays.asList("laravel", "spring", "express", "django", "flask", "yii", "ruby-on-rails", "tornado", "koa", "struts"));
        tagCache.add(framework);

        // 服务器类
        TagDTO server = new TagDTO();
        server.setTagCategory("服务器");
        server.setTags(Arrays.asList("linux", "nginx", "docker", "apache", "ubuntu", "centos", "缓存 tomcat", "负载均衡", "unix", "hadoop", "windows-server"));
        tagCache.add(server);

        // 数据库类
        TagDTO db = new TagDTO();
        db.setTagCategory("数据库");
        db.setTags(Arrays.asList("mysql", "redis", "mongodb", "sql", "oracle", "nosql memcached", "sqlserver", "postgresql", "sqlite"));
        tagCache.add(db);

        // 开发工具类
        TagDTO tool = new TagDTO();
        tool.setTagCategory("开发工具");
        tool.setTags(Arrays.asList("git", "github", "visual-studio-code", "vim", "sublime-text", "xcode intellij-idea", "eclipse", "maven", "ide", "svn", "visual-studio", "atom emacs", "textmate", "hg"));
        tagCache.add(tool);
        return tagCache;

    }
}
