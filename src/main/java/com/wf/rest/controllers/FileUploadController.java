package com.wf.rest.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@Controller
public class FileUploadController {

	
	
	@ResponseBody
	@RequestMapping(value = "/imageupload", method = RequestMethod.POST)
	public void getUploadedImagesUrls(HttpServletRequest request){
		 BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	    Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
	    List<BlobKey> blobKeys = blobs.get("myFile[]");
	    if (blobKeys == null) {
	        System.out.println("no files");
	    } else {
	        for(BlobKey blobKey : blobKeys){
	            // ImagesService services = ImagesServiceFactory.getImagesService();
	            // ServingUrlOptions serve = ServingUrlOptions.Builder.withBlobKey(blobKey);
	            // String imageUrl = services.getServingUrl(serve);
	            BlobInfoFactory blobInfoFactory = new BlobInfoFactory();
	            BlobInfo info = blobInfoFactory.loadBlobInfo(blobKey);
	         //   System.out.println("Image URL : "+info.);
	            System.out.println("Image FileName : "+info.getFilename());
	        }
	    }
	}
}
