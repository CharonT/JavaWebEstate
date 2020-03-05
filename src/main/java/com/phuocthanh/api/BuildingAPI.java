package com.phuocthanh.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phuocthanh.api.input.BuildingInput;
import com.phuocthanh.dto.BuildingDTO;
import com.phuocthanh.dto.RentAreaDTO;
import com.phuocthanh.service.IBuildingService;
import com.phuocthanh.service.impl.BuildingService;
import com.phuocthanh.utils.FormUtils;
import com.phuocthanh.utils.HttpUtils;

@WebServlet("/building") //cùng request vo 1 cái url này thì nó tự biết vô doGet hay doPost
public class BuildingAPI extends HttpServlet {
	private static final long serialVersionUID = 1L; //giống như id để phân biệt các thằng servlet khác
	private IBuildingService buildingService=new BuildingService();
    public BuildingAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper obj=new ObjectMapper();
		BuildingInput buildingInput=FormUtils.toModel(BuildingInput.class, request);
		//vd get du liệu
		
		
//		BuildingSearchBuilder builder=new BuildingSearchBuilder.Builder() //xem Class này định nghĩa sẽ hiểu
//				//khi new BuildingSearchBuilder() :goi constructor nhưng chưa co () thì vẫn chưa có bộ nhớ nên có thể gọi class inner static
//				//muc đích chưa gọi constructor là vi để có thể đệ quy gọi các hàm set khác
//				.setName(buildingInput.getName()).setDistrict(buildingInput.getDistrict())
//				.setFloorArea(buildingInput.getFloorArea())
//				.setNumberOfBasement(buildingInput.getNumberOfBasement())
//				.setRentAreaFrom(buildingInput.getRentAreaFrom())
//				.setRentAreaTo(buildingInput.getRentAreaTo())
//				.setRentCostFrom(buildingInput.getRentCostFrom())
//				.setRentCostTo(buildingInput.getRentCostTo())
//				.setStaffId(buildingInput.getStaffId())
//				.setTypes(buildingInput.getTypes())
//				.build();
//		List<BuildingDTO> result=buildingService.findAll(builder);
//		obj.writeValue(response.getOutputStream(), result); //output stream là 1 dữ liệu nhị phân
//		///hàm này đề tuần tự hóa các dữ liệu nhị phân của đối tượng sang cho response
		
		
		
		//VD tìm dữ liệu theo id
		List<BuildingDTO> result =buildingService.findById(buildingInput.getIds());
		obj.writeValue(response.getOutputStream(), result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper obj=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		//BuildingDTO buildingDTO=HttpUtils.of(request.getReader()).toModel(BuildingDTO.class);
		
		//================VD lưu dữ liệu
		RentAreaDTO dto=HttpUtils.of(request.getReader()).toModel(RentAreaDTO.class);
		Long id=buildingService.save(dto);

		obj.writeValue(response.getOutputStream(), id);
		
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper obj=new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		BuildingDTO buildingDTO=HttpUtils.of(req.getReader()).toModel(BuildingDTO.class);
		BuildingInput buildingInput=FormUtils.toModel(BuildingInput.class, req);
		List<Long> ids = buildingService.upgrade(buildingDTO, buildingInput.getIds());
		obj.writeValue(resp.getOutputStream(), ids);
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BuildingDTO dto=HttpUtils.of(req.getReader()).toModel(BuildingDTO.class);
		//buildingService.dropById(buildingInput.getIds());
		buildingService.dropRandom(dto);
	}
	

}
