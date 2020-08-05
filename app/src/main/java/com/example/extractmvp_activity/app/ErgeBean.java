package com.example.extractmvp_activity.app;

/**
 * @date：2020/8/5
 * @describe：${describe}
 * @author：LiuZhanYue
 */
public class ErgeBean {

    /**
     * id : 14414
     * album_id : 1
     * status : 1
     * score : 100
     * description :
     * created_time : 1545996453
     * owner : {"id":94085,"nickname":"宝中宝w","mobile":null,"avatar_url":null,"birthday":null,"gender":null}
     */

    private int id;
    private int album_id;
    private int status;
    private int score;
    private String description;
    private int created_time;
    private OwnerBean owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreated_time() {
        return created_time;
    }

    public void setCreated_time(int created_time) {
        this.created_time = created_time;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public static class OwnerBean {
        /**
         * id : 94085
         * nickname : 宝中宝w
         * mobile : null
         * avatar_url : null
         * birthday : null
         * gender : null
         */

        private int id;
        private String nickname;
        private Object mobile;
        private Object avatar_url;
        private Object birthday;
        private Object gender;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(Object avatar_url) {
            this.avatar_url = avatar_url;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }
    }
}
