package com.easyenglish.controller;

import com.easyenglish.service.TextVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("textvideo")
@Controller
public class TextVideoAction extends BaseAction {

	@Autowired
	private TextVideoService textVideoService;

	/*@ResponseBody
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
	public Result insertTextVideo(TextVideo textVideo, @RequestParam(value="video",required=false) MultipartFile video, @RequestParam(value="cover",required=false) MultipartFile cover, @RequestParam(value="image",required=false) MultipartFile image, HttpServletRequest request) throws IOException {
*//*	public Result insertTextVideo(TextVideo textVideo,HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile video = multipartRequest.getFile("video");
		MultipartFile image = multipartRequest.getFile("image");
		MultipartFile cover = multipartRequest.getFile("cover");*//*
		String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/textvideo");
		//Map<String,String> map  = new HashMap<>();
		if(video!=null&&!video.isEmpty()) {
			String videoName = video.getOriginalFilename();
			File videoDir = new File(path, videoName);
			if (!videoDir.exists()) {
				videoDir.mkdirs();
			}

			//MultipartFile自带的解析方法
			video.transferTo(videoDir);
			// map.put("videoName","upload/textvideo/"+videoName);
			textVideo.setVideoUrl("/upload/textvideo/"+videoName);
		}


		if(cover!=null&&!cover.isEmpty()) {
			String coverName = cover.getOriginalFilename();
			File coverDir = new File(path, coverName);
			if (!coverDir.exists()) {
				coverDir.mkdirs();
			}

			//MultipartFile自带的解析方法
			cover.transferTo(coverDir);
			//map.put("coverName","/upload/textvideo/"+coverName);
			textVideo.setCoverUrl("/upload/textvideo/"+coverName);
		}

		if(image!=null&&!image.isEmpty()){
			String imageName  = image.getOriginalFilename();
			File imageDir = new File(path,imageName);
			if(!imageDir.exists()){
				imageDir.mkdirs();
			}

			image.transferTo(imageDir);
			//map.put("imageName","upload/textvideo/"+imageName);
			textVideo.setImgUrl("/upload/textvideo/"+imageName);
		}



		int result = textVideoService.insertSelective(textVideo);

		if (result>0) {
			return Result.trueResult(ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());


		} else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}


	@ResponseBody
	@RequestMapping(value = "/deleteTextVideoByPrimaryKey", method = RequestMethod.POST)
	public Result deleteByPrimaryKey(Integer tvId){

		if(tvId==null){
			return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
					ErrorCodeConstant.E00002.getCode());
		}

		int insertSelective = textVideoService.deleteByPrimaryKey(tvId);
		
		if (insertSelective> 0) {
			return new Result(true, ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		} else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}
	
	@ResponseBody
	@RequestMapping(value = "/updateTextVideoByPrimaryKey", method = RequestMethod.POST)
	public Result updateByPrimaryKeySelective(TextVideo textVideo,@RequestParam(value="video",required=false) MultipartFile video, @RequestParam(value="cover",required=false) MultipartFile cover, @RequestParam(value="image",required=false) MultipartFile image, HttpServletRequest request) throws IOException {

		if(textVideo==null){
			return Result.falseResult(ErrorCodeConstant.E00003.getMessage(),
					ErrorCodeConstant.E00003.getCode());
		}

		if(textVideo.getTvId()==null){
			return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
					ErrorCodeConstant.E00002.getCode());
		}

		TextVideo textVideo_old =  textVideoService.selectByPrimaryKey(textVideo.getTvId());



		String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/textvideo");
		String path2 = request.getSession().getServletContext().getRealPath("WEB-INF");
		//Map<String,String> map  = new HashMap<>();
		if(video!=null&&!video.isEmpty()) {
			//删除旧的路径
			File  file= new File(path2 + textVideo_old.getVideoUrl());
			if(file.exists()){
				FileUtils.forceDelete(file);
			}

			//新增路径
			String videoName = video.getOriginalFilename();
			File videoDir = new File(path, videoName);
			if (!videoDir.exists()) {
				videoDir.mkdirs();
			}

			//MultipartFile自带的解析方法
			video.transferTo(videoDir);
			// map.put("videoName","upload/textvideo/"+videoName);
			textVideo.setVideoUrl("/upload/textvideo/"+videoName);
		}


		if(cover!=null&&!cover.isEmpty()) {
			//删除旧的路径

			File  file= new File(path2+textVideo_old.getCoverUrl());
			if(file.exists()){
				FileUtils.forceDelete(file);
			}
			//新增路径
			String coverName = cover.getOriginalFilename();
			File coverDir = new File(path, coverName);
			if (!coverDir.exists()) {
				coverDir.mkdirs();
			}

			//MultipartFile自带的解析方法
			cover.transferTo(coverDir);
			//map.put("coverName","/upload/textvideo/"+coverName);
			textVideo.setCoverUrl("/upload/textvideo/"+coverName);
		}

		if(image!=null&&!image.isEmpty()){
			//删除旧的路径

			File  file= new File(path2+textVideo_old.getImgUrl());
			if(file.exists()){
				FileUtils.forceDelete(file);
			}
			//新增路径
			String imageName  = image.getOriginalFilename();
			File imageDir = new File(path,imageName);
			if(!imageDir.exists()){
				imageDir.mkdirs();
			}

			image.transferTo(imageDir);
			//map.put("imageName","upload/textvideo/"+imageName);
			textVideo.setImgUrl("/upload/textvideo/"+imageName);
		}












		int updateByPrimaryKeySelective = textVideoService.updateByPrimaryKeySelective(textVideo);
		
		
		if (updateByPrimaryKeySelective> 0) {
			return new Result(true, ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		} else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}


	}
	
	@ResponseBody
	@RequestMapping(value = "/selectTextVideoByPrimaryKey", method = RequestMethod.GET)
	public Result selectByPrimaryKey(Integer tvId){
		TextVideo selectByPrimaryKey = textVideoService.selectByPrimaryKey(tvId);
		
		if(tvId==null){
			return Result.falseResult(ErrorCodeConstant.E00002.getMessage(),
					ErrorCodeConstant.E00002.getCode());
		}
		
		if (selectByPrimaryKey!=null) {
			return new Result(true,selectByPrimaryKey,ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		} else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}



	@ResponseBody
	@RequestMapping(value = "/selectTextVideoByKeyWordByPage", method = RequestMethod.GET)
	public Result selectByKeyWordByPage(Page page, String keyWord){
		PageResult<TextVideo> selectByKeyWord = textVideoService.selectByKeyWordByPage(page,keyWord);


		if (selectByKeyWord!=null&&selectByKeyWord.getData().size()>0) {
			return new Result(true,selectByKeyWord, ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		}

		if (selectByKeyWord!=null&&selectByKeyWord.getData().size()==0) {
			return new Result(true, ErrorCodeConstant.E00004.getMessage(),
					ErrorCodeConstant.E00004.getCode());

		}
		else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectAllTextVideoByGradeByPage", method = RequestMethod.GET)
	public Result selectAllByGradeByPage(Page page, Integer grade_id){
		PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByGradeByPage(page,grade_id);
		
		
		
		if (selectAllByPage!=null&&selectAllByPage.getData().size()>0) {
			return new Result(true,selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		} 
		
		if (selectAllByPage!=null&&selectAllByPage.getData().size()==0) {
			return new Result(true, ErrorCodeConstant.E00004.getMessage(),
					ErrorCodeConstant.E00004.getCode());

		} 
		else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/selectAllTextVideoByTextBookByPage", method = RequestMethod.GET)
	public Result selectAllByTextBookByPage(Page page, Integer textbook_id){
		PageResult<TextVideo> selectAllByPage = textVideoService.selectAllByTextBookByPage(page,textbook_id);
		
		
		
		if (selectAllByPage!=null&&selectAllByPage.getData().size()>0) {
			return new Result(true,selectAllByPage, ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		} 
		
		if (selectAllByPage!=null&&selectAllByPage.getData().size()==0) {
			return new Result(true, ErrorCodeConstant.E00004.getMessage(),
					ErrorCodeConstant.E00004.getCode());

		} 
		else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}





	@ResponseBody
	@RequestMapping(value = "/selectTextVideoByTitle", method = RequestMethod.GET)
	public Result selectTextVideoByTitle(Page page, String title) {
		TextVideo textVideo = textVideoService.selectTextVideoByTitle(page, title);
		if (textVideo!=null) {
			return new Result(true,textVideo,ErrorCodeConstant.E00001.getMessage(),
					ErrorCodeConstant.E00001.getCode());

		} else {
			return Result.falseResult(ErrorCodeConstant.E00000.getMessage(),
					ErrorCodeConstant.E00000.getCode());
		}

	}
*/


	
}
