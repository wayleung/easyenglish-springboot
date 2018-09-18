package com.easyenglish.controller;

import com.easyenglish.dto.Admin;
import com.easyenglish.dto.TextVideo;
import com.easyenglish.dto.User;
import com.easyenglish.dto.VideoEnglish;
import com.easyenglish.exception.ErrorCodeConstant;
import com.easyenglish.service.AdminService;
import com.easyenglish.service.TextVideoService;
import com.easyenglish.service.UserService;
import com.easyenglish.service.VideoEnglishService;
import com.easyenglish.utils.md5.MD5Util;
import com.easyenglish.vo.Page;
import com.easyenglish.vo.PageResult;
import com.easyenglish.vo.Result;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequestMapping("admin")
@Controller
public class AdminAction extends BaseAction {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private TextVideoService textVideoService;


    @Autowired
    private VideoEnglishService videoEnglishService;

    @ResponseBody
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Result login(String username, String inputPassword, String validateCode, HttpServletRequest request) {
        System.out.println(username);
        System.out.println(inputPassword);

//        if (request.getSession().getAttribute("admin") != null) {
//            return Result.falseResult(ErrorCodeConstant.E00011.getMessage(),
//                    ErrorCodeConstant.E00011.getCode());
//        }

        if (StringUtils.isBlank(username)) {
            return Result.falseResult(ErrorCodeConstant.E00009.getMessage(),
                    ErrorCodeConstant.E00009.getCode());
        }

        if (StringUtils.isBlank(inputPassword)) {
            return Result.falseResult(ErrorCodeConstant.E00010.getMessage(),
                    ErrorCodeConstant.E00010.getCode());
        }

        if (StringUtils.isBlank(validateCode)) {
            return Result.falseResult(ErrorCodeConstant.E00006.getMessage(),
                    ErrorCodeConstant.E00006.getCode());
        }


/*        //账户名格式验证
        String usernameRegEx = "^[0-9A-Za-z]{6,20}$";
//        System.out.println(Pattern.matches(regEx, content));
        boolean usernameMatch = Pattern.matches(usernameRegEx, username);
        if(!usernameMatch){
            return Result.falseResult(ErrorCodeConstant.E00013.getMessage(),
                    ErrorCodeConstant.E00013.getCode());
        }*/


        //验证码判断

        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        if (!verifyCode.endsWith(validateCode)) {
            return Result.falseResult(ErrorCodeConstant.E00007.getMessage(),
                    ErrorCodeConstant.E00007.getCode());
        }


        Admin admin = adminService.selectByUsername(username);


        if (admin == null) {
            return Result.falseResult(ErrorCodeConstant.E00005.getMessage(),
                    ErrorCodeConstant.E00005.getCode());
        } else {
            String password = admin.getPassword();

            boolean isCorrect = MD5Util.verify(inputPassword, password);
            if (isCorrect) {
                request.getSession().setAttribute("admin", admin);
                return new Result(true, admin,
                        ErrorCodeConstant.E00001.getMessage(),
                        ErrorCodeConstant.E00001.getCode());
            } else {
                return Result.falseResult(ErrorCodeConstant.E00005.getMessage(),
                        ErrorCodeConstant.E00005.getCode());
            }

        }
    }

    @ResponseBody
    @RequestMapping(value = "/adminRegister", method = RequestMethod.POST)
    public Result register(String username, String password, String validateCode) {
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "/adminLogout", method = RequestMethod.POST)
    public Result logout(HttpServletRequest request) {
        request.getSession().setAttribute("admin", null);
        return Result.trueResult(ErrorCodeConstant.E00012.getMessage(), ErrorCodeConstant.E00012.getCode());
    }


    @ResponseBody
    @RequestMapping(value = "/selectAllUserByPage", method = RequestMethod.GET)
    public Result selectAllUserByPage(Page page) {
        PageResult<User> selectAllByPage = userService.selectAllByPage(page);
        /*if (selectAllByPage != null && selectAllByPage.getData() != null
                && selectAllByPage.getData().size() > 0) {*/
        if (selectAllByPage != null) {
            return new Result(true, selectAllByPage,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/selectAllUserByKeyWordByPage", method = RequestMethod.GET)
    public Result selectAllUserByKeyWordByPage(String keyword, Page page) {
        PageResult<User> selectByKeyWordByPage = userService.selectByKeyWordByPage(page, keyword);
        /*if (selectByKeyWordByPage != null && selectByKeyWordByPage.getData() != null
                && selectByKeyWordByPage.getData().size() > 0) {*/
        if (selectByKeyWordByPage != null) {
            return new Result(true, selectByKeyWordByPage,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/deleteUserByPrimaryKey", method = RequestMethod.POST)
    public Result deleteUserByPrimaryKey(Integer userId) {
        if (userId == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        Integer result = userService.deleteByPrimaryKey(userId);
        /*if (selectByKeyWordByPage != null && selectByKeyWordByPage.getData() != null
                && selectByKeyWordByPage.getData().size() > 0) {*/
        if (result > 0) {
            return Result.trueResult(ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/updateUserByPrimaryKey", method = RequestMethod.POST)
    public Result updateUserByPrimaryKey(User user) {
        if (user.getUserId() == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        String newPassword = MD5Util.generate(user.getPassword());
        user.setPassword(newPassword);


        Integer result = userService.updateByPrimaryKeySelective(user);
        /*if (selectByKeyWordByPage != null && selectByKeyWordByPage.getData() != null
                && selectByKeyWordByPage.getData().size() > 0) {*/
        if (result > 0) {
            return Result.trueResult(ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectUserByUsername", method = RequestMethod.GET)
    public Result selectUserByUsername(String username) {
        User user = userService.selectByUsername(username);
        if (user != null) {
            return new Result(true, user, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public Result insertUser(User user) {
        int result = userService.insertSelective(user);
        if (result > 0) {
            return Result.trueResult(ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }



     /*
        TextVideo start
         */


    @ResponseBody
    @RequestMapping(value = "/selectAllTextVideoByPage", method = RequestMethod.GET)
    public Result selectAllTextVideoByPage(Page page) {
        PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByPage(page);
        if (selectAllByPage != null) {
            return new Result(true, selectAllByPage,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/insertTextVideo", method = RequestMethod.POST)
    public Result insertTextVideo(TextVideo textVideo, @RequestParam(value = "video", required = false) MultipartFile video, @RequestParam(value = "cover", required = false) MultipartFile cover, @RequestParam(value = "image", required = false) MultipartFile[] images, HttpServletRequest request) throws IOException {
/*	public Result insertTextVideo(TextVideo textVideo,HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile video = multipartRequest.getFile("video");
		MultipartFile image = multipartRequest.getFile("image");
		MultipartFile cover = multipartRequest.getFile("cover");*/
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/textvideo");
        //Map<String,String> map  = new HashMap<>();
        if (video != null && !video.isEmpty()) {
            String videoName = new Date().getTime()+"_"+video.getOriginalFilename();
            File videoDir = new File(path, videoName);
            if (!videoDir.exists()) {
                videoDir.mkdirs();
            }

            //MultipartFile自带的解析方法
            video.transferTo(videoDir);
            // map.put("videoName","upload/textvideo/"+videoName);
            textVideo.setVideoUrl("/upload/textvideo/" + videoName);
        }


        if (cover != null && !cover.isEmpty()) {
            String coverName = new Date().getTime()+"_"+cover.getOriginalFilename();
            File coverDir = new File(path, coverName);
            if (!coverDir.exists()) {
                coverDir.mkdirs();
            }

            //MultipartFile自带的解析方法
            cover.transferTo(coverDir);
            //map.put("coverName","/upload/textvideo/"+coverName);
            textVideo.setCoverUrl("/upload/textvideo/" + coverName);
        }


        if (images != null && images.length > 0) {
            String imgUrl = "";
            for (int i = 0; i < images.length; i++) {
                if (images[i] != null && !images[i].isEmpty()) {
                    String imageName = new Date().getTime()+"_"+images[i].getOriginalFilename();
                    File imageDir = new File(path, imageName);
                    if (!imageDir.exists()) {
                        imageDir.mkdirs();
                    }

                    images[i].transferTo(imageDir);
                    //map.put("imageName","upload/textvideo/"+imageName);
                    String imageStr = "/upload/textvideo/" + imageName + ";";
                    imgUrl = imgUrl + imageStr;
                }
            }


            textVideo.setImgUrl(imgUrl);

        }


        int result = textVideoService.insertSelective(textVideo);

        if (result > 0) {
            return Result.trueResult(ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());


        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/deleteTextVideoByPrimaryKey", method = RequestMethod.POST)
    public Result deleteByPrimaryKey(Integer tvId, HttpServletRequest request) throws IOException {

        if (tvId == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        TextVideo textVideo = textVideoService.selectByPrimaryKey(tvId);
        String coverUrl = textVideo.getCoverUrl();
        String imgUrl = textVideo.getImgUrl();
        String videoUrl = textVideo.getVideoUrl();

        int insertSelective = textVideoService.deleteByPrimaryKey(tvId);

        if (insertSelective > 0) {


            String path = request.getSession().getServletContext().getRealPath("WEB-INF");
            //Map<String,String> map  = new HashMap<>();
            //删除旧的路径
            if (StringUtils.isNotBlank(coverUrl)) {

                File file = new File(path + coverUrl);
                if (file.exists()&&file.isFile()) {
                    FileUtils.forceDelete(file);
                }
            }

            String[] imgUrls = imgUrl.split(";");

            for (int j = 0; j < imgUrls.length; j++) {
                if (StringUtils.isNotBlank(imgUrls[j])) {

                    File file = new File(path + imgUrls[j]);
                    if (file.exists()&&file.isFile()) {
                        FileUtils.forceDelete(file);
                    }
                }
            }






          /*  if (StringUtils.isNotBlank(imgUrl)) {

                File file = new File(path + imgUrl);
                if (file.exists()) {
                    FileUtils.forceDelete(file);
                }
            }*/

            if (StringUtils.isNotBlank(videoUrl)) {

                File file = new File(path + videoUrl);
                if (file.exists()&&file.isFile()) {
                    FileUtils.forceDelete(file);
                }
            }


            return new Result(true, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/updateTextVideoByPrimaryKey", method = RequestMethod.POST)
    public Result updateByPrimaryKeySelective(TextVideo textVideo, @RequestParam(value = "video", required = false) MultipartFile video, @RequestParam(value = "cover", required = false) MultipartFile cover, @RequestParam(value = "image", required = false) MultipartFile[] images, HttpServletRequest request) throws IOException {

        System.out.println(textVideo);

        if (textVideo == null) {
            return Result.falseResult(ErrorCodeConstant.E00003.getMessage(),
                    ErrorCodeConstant.E00003.getCode());
        }

        if (textVideo.getTvId() == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        TextVideo textVideo_old = textVideoService.selectByPrimaryKey(textVideo.getTvId());
/*        textVideo.setImgUrl(textVideo_old.getImgUrl());
        textVideo.setCoverUrl(textVideo_old.getCoverUrl());
        textVideo.setVideoUrl(textVideo_old.getVideoUrl());*/

        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/textvideo");
        String path2 = request.getSession().getServletContext().getRealPath("WEB-INF");
        System.out.println("path2:" + path2);
        //Map<String,String> map  = new HashMap<>();
        if (video != null && !video.isEmpty()) {
            //删除旧的路径
            if (StringUtils.isNotBlank(textVideo_old.getVideoUrl())) {
                File file = new File(path2 + textVideo_old.getVideoUrl());
                if (file.exists()&&file.isFile()) {
                    FileUtils.forceDelete(file);
                }
            }


            //新增路径
            String videoName = new Date().getTime()+"_"+video.getOriginalFilename();
            File videoDir = new File(path, videoName);
            if (!videoDir.exists()) {
                videoDir.mkdirs();
            }

            //MultipartFile自带的解析方法
            video.transferTo(videoDir);
            // map.put("videoName","upload/textvideo/"+videoName);
            textVideo.setVideoUrl("/upload/textvideo/" + videoName);
        }


        if (cover != null && !cover.isEmpty()) {
            //删除旧的路径
            if (StringUtils.isNotBlank(textVideo_old.getCoverUrl())) {
                File file = new File(path2 + textVideo_old.getCoverUrl());
                if (file.exists()) {
                    FileUtils.forceDelete(file);
                }
            }
            //新增路径
            String coverName = new Date().getTime()+"_"+cover.getOriginalFilename();
            File coverDir = new File(path, coverName);
            if (!coverDir.exists()) {
                coverDir.mkdirs();
            }

            //MultipartFile自带的解析方法
            cover.transferTo(coverDir);
            //map.put("coverName","/upload/textvideo/"+coverName);
            textVideo.setCoverUrl("/upload/textvideo/" + coverName);
        }


        //新增路径
        if (images != null && images.length > 0) {

            //删除旧的路径
            if (StringUtils.isNotBlank(textVideo_old.getImgUrl())) {
                String ImgUrls_old = textVideo_old.getImgUrl();
                String[] ImgUrl_old = ImgUrls_old.split(";");
                for (int i = 0; i < ImgUrl_old.length; i++) {
                    File file = new File(path2 + ImgUrl_old[i]);
                    if (file.exists()) {
                        FileUtils.forceDelete(file);
                    }
                }
            }


            String imgUrl = "";
            for (int i = 0; i < images.length; i++) {


                if (images[i] != null && !images[i].isEmpty()) {


                    //新增路径
                    if (images[i] != null && !images[i].isEmpty()) {
                        String imageName = new Date().getTime()+"_"+images[i].getOriginalFilename();
                        File imageDir = new File(path, imageName);
                        if (!imageDir.exists()) {
                            imageDir.mkdirs();
                        }

                        images[i].transferTo(imageDir);
                        //map.put("imageName","upload/textvideo/"+imageName);
                        String imageStr = "/upload/textvideo/" + imageName + ";";
                        imgUrl = imgUrl + imageStr;
                    }
                }

                textVideo.setImgUrl(imgUrl);


            }
        }


        int updateByPrimaryKeySelective = textVideoService.updateByPrimaryKeySelective(textVideo);


        if (updateByPrimaryKeySelective > 0) {
            return new Result(true, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }


    }

    @ResponseBody
    @RequestMapping(value = "/selectTextVideoByPrimaryKey", method = RequestMethod.GET)
    public Result selectByPrimaryKey(Integer tvId) {
        TextVideo selectByPrimaryKey = textVideoService.selectByPrimaryKey(tvId);

        if (tvId == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        if (selectByPrimaryKey != null) {
            return new Result(true, selectByPrimaryKey, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectTextVideoByKeyWordByPage", method = RequestMethod.GET)
    public Result selectByKeyWordByPage(String keyWord, Page page) {
        PageResult<TextVideo> selectByKeyWord = textVideoService.selectByKeyWordByPage(keyWord, page);


        if (selectByKeyWord != null && selectByKeyWord.getData().size() > 0) {
            return new Result(true, selectByKeyWord, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectByKeyWord != null && selectByKeyWord.getData().size() == 0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllTextVideoByGradeByPage", method = RequestMethod.GET)
    public Result selectAllByGradeByPage(Integer grade_id, Page page) {
        PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByGradeByPage(grade_id, page);


        if (selectAllByPage != null && selectAllByPage.getData().size() > 0) {
            return new Result(true, selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage != null && selectAllByPage.getData().size() == 0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllTextVideoByTextBookByPage", method = RequestMethod.GET)
    public Result selectAllByTextBookByPage(Integer textbook_id, Page page) {
        PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByTextBookByPage(textbook_id, page);


        if (selectAllByPage != null && selectAllByPage.getData().size() > 0) {
            return new Result(true, selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage != null && selectAllByPage.getData().size() == 0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectTextVideoByTitle", method = RequestMethod.GET)
    public Result selectTextVideoByTitle(String title, Page page) {
        TextVideo textVideo = textVideoService.selectTextVideoByTitle(title, page);
        if (textVideo != null) {
            return new Result(true, textVideo, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


     /*
        TextVideo end
         */



    /*
    VideoEnglish start
     */


    @ResponseBody
    @RequestMapping(value = "/selectAllVideoEnglishByPage", method = RequestMethod.GET)
    public Result selectAllVideoEnglishByPage(Page page) {
        PageResult<VideoEnglish> selectAllByPage = videoEnglishService.selectAllByPage(page);
        if (selectAllByPage != null) {
            return new Result(true, selectAllByPage,
                    ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/insertVideoEnglish", method = RequestMethod.POST)
    public Result insertVideoEnglish(VideoEnglish videoEnglish, @RequestParam(value = "cover", required = false) MultipartFile cover, @RequestParam(value = "image", required = false) MultipartFile[] images, HttpServletRequest request) throws IOException {
//    public Result insertVideoEnglish(VideoEnglish videoEnglish, @RequestParam(value = "video", required = false) MultipartFile video, @RequestParam(value = "cover", required = false) MultipartFile cover, @RequestParam(value = "image", required = false) MultipartFile[] images, HttpServletRequest request) throws IOException {
/*	public Result insertVideoEnglish(VideoEnglish videoEnglish,HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile video = multipartRequest.getFile("video");
		MultipartFile image = multipartRequest.getFile("image");
		MultipartFile cover = multipartRequest.getFile("cover");*/
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/videoenglish");
        //Map<String,String> map  = new HashMap<>();


        if (cover != null && !cover.isEmpty()) {
            String coverName = new Date().getTime()+"_"+cover.getOriginalFilename();
            File coverDir = new File(path, coverName);
            if (!coverDir.exists()) {
                coverDir.mkdirs();
            }

            //MultipartFile自带的解析方法
            cover.transferTo(coverDir);
            //map.put("coverName","/upload/videoenglish/"+coverName);
            videoEnglish.setCoverUrl("/upload/videoenglish/" + coverName);
        }


        if (images != null && images.length > 0) {
            String imgUrl = "";
            for (int i = 0; i < images.length; i++) {
                if (images[i] != null && !images[i].isEmpty()) {
                    String imageName = new Date().getTime()+"_"+images[i].getOriginalFilename();
                    File imageDir = new File(path, imageName);
                    if (!imageDir.exists()) {
                        imageDir.mkdirs();
                    }

                    images[i].transferTo(imageDir);
                    //map.put("imageName","upload/videoenglish/"+imageName);
                    String imageStr = "/upload/videoenglish/" + imageName + ";";
                    imgUrl = imgUrl + imageStr;
                }
            }


            videoEnglish.setImgUrl(imgUrl);

        }


        int result = videoEnglishService.insertSelective(videoEnglish);

        if (result > 0) {
            return Result.trueResult(ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());


        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/deleteVideoEnglishByPrimaryKey", method = RequestMethod.POST)
    public Result deleteVideoEnglishByPrimaryKey(Integer tvId, HttpServletRequest request) throws IOException {

        if (tvId == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        VideoEnglish videoEnglish = videoEnglishService.selectByPrimaryKey(tvId);
        String coverUrl = videoEnglish.getCoverUrl();
        String imgUrl = videoEnglish.getImgUrl();
        //String videoUrl = videoEnglish.getVideoUrl();

        int insertSelective = videoEnglishService.deleteByPrimaryKey(tvId);

        if (insertSelective > 0) {


            String path = request.getSession().getServletContext().getRealPath("WEB-INF");
            //Map<String,String> map  = new HashMap<>();
            //删除旧的路径
            if (StringUtils.isNotBlank(coverUrl)) {

                File file = new File(path + coverUrl);
                if (file.exists()&&file.isFile()) {
                    FileUtils.forceDelete(file);
                }
            }

            String[] imgUrls = imgUrl.split(";");

            for (int j = 0; j < imgUrls.length; j++) {
                if (StringUtils.isNotBlank(imgUrls[j])) {

                    File file = new File(path + imgUrls[j]);
                    if (file.exists()&&file.isFile()) {
                        FileUtils.forceDelete(file);
                    }
                }
            }

            return new Result(true, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }

    @ResponseBody
    @RequestMapping(value = "/updateVideoEnglishByPrimaryKey", method = RequestMethod.POST)
    public Result updateVideoEnglishByPrimaryKey(VideoEnglish videoEnglish, @RequestParam(value = "cover", required = false) MultipartFile cover, @RequestParam(value = "image", required = false) MultipartFile[] images, HttpServletRequest request) throws IOException {

        System.out.println(videoEnglish);

        if (videoEnglish == null) {
            return Result.falseResult(ErrorCodeConstant.E00003.getMessage(),
                    ErrorCodeConstant.E00003.getCode());
        }

        if (videoEnglish.getTvId() == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        VideoEnglish videoEnglish_old = videoEnglishService.selectByPrimaryKey(videoEnglish.getTvId());
/*        videoEnglish.setImgUrl(videoEnglish_old.getImgUrl());
        videoEnglish.setCoverUrl(videoEnglish_old.getCoverUrl());
        videoEnglish.setVideoUrl(videoEnglish_old.getVideoUrl());*/

        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/videoenglish");
        String path2 = request.getSession().getServletContext().getRealPath("WEB-INF");
        System.out.println("path2:" + path2);


        if (cover != null && !cover.isEmpty()) {
            //删除旧的路径
            if (StringUtils.isNotBlank(videoEnglish_old.getCoverUrl())) {
                File file = new File(path2 + videoEnglish_old.getCoverUrl());
                if (file.exists()&&file.isFile()) {
                    FileUtils.forceDelete(file);
                }
            }
            //新增路径
            String coverName = new Date().getTime()+"_"+cover.getOriginalFilename();
            File coverDir = new File(path, coverName);
            if (!coverDir.exists()) {
                coverDir.mkdirs();
            }

            //MultipartFile自带的解析方法
            cover.transferTo(coverDir);
            //map.put("coverName","/upload/videoenglish/"+coverName);
            videoEnglish.setCoverUrl("/upload/videoenglish/" + coverName);
        }


        //新增路径
        if (images != null && images.length > 0&&!images[0].isEmpty()) {

            //删除旧的路径
            if (StringUtils.isNotBlank(videoEnglish_old.getImgUrl())) {
                String ImgUrls_old = videoEnglish_old.getImgUrl();
                String[] ImgUrl_old = ImgUrls_old.split(";");
                for (int i = 0; i < ImgUrl_old.length; i++) {
                    File file = new File(path2 + ImgUrl_old[i]);
                    if (file.exists()&&file.isFile()) {
                        FileUtils.forceDelete(file);
                    }
                }
            }


            String imgUrl = "";
            for (int i = 0; i < images.length; i++) {


                if (images[i] != null && !images[i].isEmpty()) {


                    //新增路径
                    if (images[i] != null && !images[i].isEmpty()) {
                        String imageName = new Date().getTime()+"_"+images[i].getOriginalFilename();
                        File imageDir = new File(path, imageName);
                        if (!imageDir.exists()) {
                            imageDir.mkdirs();
                        }

                        images[i].transferTo(imageDir);
                        //map.put("imageName","upload/videoenglish/"+imageName);
                        String imageStr = "/upload/videoenglish/" + imageName + ";";
                        imgUrl = imgUrl + imageStr;
                    }
                }

                videoEnglish.setImgUrl(imgUrl);


            }
        }


        int updateByPrimaryKeySelective = videoEnglishService.updateByPrimaryKeySelective(videoEnglish);


        if (updateByPrimaryKeySelective > 0) {
            return new Result(true, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }


    }

    @ResponseBody
    @RequestMapping(value = "/selectVideoEnglishByPrimaryKey", method = RequestMethod.GET)
    public Result selectVideoEnglishByPrimaryKey(Integer tvId) {
        VideoEnglish selectByPrimaryKey = videoEnglishService.selectByPrimaryKey(tvId);

        if (tvId == null) {
            return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
                    ErrorCodeConstant.E00002.getCode());
        }

        if (selectByPrimaryKey != null) {
            return new Result(true, selectByPrimaryKey, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectVideoEnglishByKeyWordByPage", method = RequestMethod.GET)
    public Result selectVideoEnglishByKeyWordByPage(String keyWord, Page page) {
        PageResult<VideoEnglish> selectByKeyWord = videoEnglishService.selectByKeyWordByPage(keyWord, page);


        if (selectByKeyWord != null && selectByKeyWord.getData().size() > 0) {
            return new Result(true, selectByKeyWord, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectByKeyWord != null && selectByKeyWord.getData().size() == 0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllVideoEnglishByGradeByPage", method = RequestMethod.GET)
    public Result selectAllVideoEnglishByGradeByPage(Integer grade_id, Page page) {
        PageResult<VideoEnglish> selectAllByPage = videoEnglishService.selectAllByGradeByPage(grade_id, page);


        if (selectAllByPage != null && selectAllByPage.getData().size() > 0) {
            return new Result(true, selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage != null && selectAllByPage.getData().size() == 0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectAllVideoEnglishByTextBookByPage", method = RequestMethod.GET)
    public Result selectAllVideoEnglishByTextBookByPage(Integer textbook_id, Page page) {
        PageResult<VideoEnglish> selectAllByPage = videoEnglishService.selectAllByTextBookByPage(textbook_id, page);


        if (selectAllByPage != null && selectAllByPage.getData().size() > 0) {
            return new Result(true, selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        }

        if (selectAllByPage != null && selectAllByPage.getData().size() == 0) {
            return new Result(false, ErrorCodeConstant.E00004.getMessage(),
                    ErrorCodeConstant.E00004.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    @ResponseBody
    @RequestMapping(value = "/selectVideoEnglishByTitle", method = RequestMethod.GET)
    public Result selectVideoEnglishByTitle(String title, Page page) {
        VideoEnglish videoEnglish = videoEnglishService.selectVideoEnglishByTitle(title, page);
        if (videoEnglish != null) {
            return new Result(true, videoEnglish, ErrorCodeConstant.E00001.getMessage(),
                    ErrorCodeConstant.E00001.getCode());

        } else {
            return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
                    ErrorCodeConstant.E00000.getCode());
        }

    }


    /*
    VideoEnglish end
     */


    @RequestMapping(value = "/uploadTest", method = RequestMethod.POST)
    @ResponseBody
    public Result uploadTest(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest
            request) throws IllegalStateException, IOException {

        //String path = request.getSession().getServletContext().getRealPath("/");
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/textvideo");
        String fileName = new Date().getTime()+"_"+file.getOriginalFilename();
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        Map<String, String> map = new HashMap<>();
        map.put("fileName", "upload/textvideo/" + fileName);
        return new Result(true, map, ErrorCodeConstant.E00001.getMessage(),
                ErrorCodeConstant.E00001.getCode());

    }


    @RequestMapping(value = "/authCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman", 0, 28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for (int i = 0; i < 40; i++) {
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String verifyCode = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            verifyCode = verifyCode + rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 28);
        }
        //将字符保存到session中用于前端的验证
        request.getSession().setAttribute("verifyCode", verifyCode);


        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
    }

    //创建颜色
    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    /**
     * 进行验证用户的验证码是否正确
     * @param value 用户输入的验证码
     * @param request HttpServletRequest对象
     * @return 一个String类型的字符串。格式为：<br/>
     *                     {"res",boolean},<br/>
     *                 如果为{"res",true}，表示验证成功<br/>
     *                 如果为{"res",false}，表示验证失败
     *
     */
/*    @RequestMapping(value="/validate")
    @ResponseBody
    public String validate(String value,HttpServletRequest request){
        String valueCode=(String)request.getSession().getAttribute("strCode");
        Map map=new HashMap();
        if(valueCode!=null){
            if(valueCode.equals(value)){
                map.put("res", true);
                return new Gson().toJson(map);
            }
        }
        map.put("res", false);
        return new Gson().toJson(map);
    }*/


    /**
     * 删除指定文件名的上传的文件
     */
    public void deleteFileByFileNameOnDisk(String fileName, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/textvideo");
        File dir = new File(path, fileName);
        if (dir.exists()) {
            FileUtils.deleteDirectory(dir);
        }
    }
}
