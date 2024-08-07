package com.marondal.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.database.domain.UsedGoods;
import com.marondal.spring.ex.database.service.UsedGoodsService;

// request와 response 처리 담당
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		
		// 중고물품 게시글 리스트 얻어 오기 
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		
		return usedGoodsList;
	}
	

}
