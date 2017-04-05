package com.kevin.refactor.method;

/**
 * 详情 :《重构》曾经有个章节说到处理多个特殊if的情况就是使用数组来替代
 * <p>
 * 详细 : 我看的时候稍微过了一眼，觉得没什么，但是后来我真的在开发中遇到的时候，
 * 突然想起这个小技巧，虽然看起来很简单，但是实用
 *
 * @author liangguanglong 17/4/3
 */
public class LoopReplaceIf {

    /**
     * 差的写法
     */
    public String reBuildGitURLBad(String repoURL, String userName, String password) {
        String checkoutShell = "git clone ";

        if (repoURL.startsWith("http://")) {
            String replaceStr = "http://" + userName + ":" + password + "@";
            checkoutShell = checkoutShell + repoURL.replaceFirst("http://", replaceStr) + "\n";
        }
        if (repoURL.startsWith("https://")) {
            String replaceStr = "https://" + userName + ":" + password + "@";
            checkoutShell = checkoutShell + repoURL.replaceFirst("https://", replaceStr) + "\n";
        }
        if (repoURL.startsWith("git")) {
            String replaceStr = "git" + userName + ":" + password + "@";
            checkoutShell = checkoutShell + repoURL.replaceFirst("git", replaceStr) + "\n";
        }
        return checkoutShell;
    }

    /**
     * 好的写法
     */
    public String reBuildGitURLGood(String repoURL, String userName, String password) {
        String checkoutShell = "git clone ";
        String[] gitURLStartArr = {"http://", "https://", "git"};
        for (String startStr : gitURLStartArr) {
            if (repoURL.startsWith(startStr)) {
                String replaceStr = startStr + userName + ":" + password + "@";
                checkoutShell = checkoutShell + repoURL.replaceFirst(startStr, replaceStr) + "\n";
                break;
            }
        }
        return checkoutShell;
    }
}
