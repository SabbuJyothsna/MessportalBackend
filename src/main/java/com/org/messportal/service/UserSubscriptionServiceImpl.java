package com.org.messportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.messportal.dao.UserSubscriptionRepository;
import com.org.messportal.dto.SubscriptionDTO;
import com.org.messportal.entity.User;
import com.org.messportal.entity.UserSubscription;
import com.org.messportal.util.ACTIVE;

@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

	@Autowired
	private UserSubscriptionRepository userSubscriptionRepository;

	@Override
	public ResponseEntity<List<SubscriptionDTO>> findAllUserSubscriptions() {
		// TODO Auto-generated method stub
		List<UserSubscription> usersubscribe = userSubscriptionRepository.findAll();
		List<SubscriptionDTO> usersubDto = new ArrayList<SubscriptionDTO>();
		if (usersubscribe != null && !usersubscribe.isEmpty()) {
			usersubscribe.forEach(usersub -> {
				SubscriptionDTO userD = getSubscriptionDtoFromSubscribe(usersub);
				usersubDto.add(userD);

			});
			return ResponseEntity.ok(usersubDto);
		}
		return null;
	}

	private SubscriptionDTO getSubscriptionDtoFromSubscribe(UserSubscription usersub) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public ResponseEntity<UserSubscription> findUserSubscriptionById(int id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(userSubscriptionRepository.findById(id).orElse(null));
	}

	@Override
	public ResponseEntity<SubscriptionDTO> addAllRoles(SubscriptionDTO subscriptionDTO, User customer) {
		// TODO Auto-generated method stub

		UserSubscription userSubscription = userSubscriptionRepository
				.save(getSubscriptionFromSubscriptionDTO(subscriptionDTO));
		return ResponseEntity.ok(subscriptionDTO);
	}

	private UserSubscription getSubscriptionFromSubscriptionDTO(SubscriptionDTO subscriptionDTO) {
		// TODO Auto-generated method stub

		UserSubscription userSubscription = new UserSubscription();

		userSubscription.setActive(ACTIVE.ACTIVE);
		userSubscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());

		// System.out.println(orderDto.toString());
//		order.setDeliveryType(orderDto.getDeliveryType());
//		order.setOrderCode("sdfghj");
//		order.setStatus(ORDER_STATUS.BOOKED);
//		order.setUpdatedTime(LocalDateTime.now());
//		MenuDetail menudetail = FindMenuById(orderDto.getMenuId());
//		order.setMenuDetail(menudetail);
//		order.setAddress(findAddressById(orderDto.getAddressId()));
//		order.setUser1(findUserById(customer.getId()));
//		order.setUser2(findUserById(orderDto.getVendorId()));
		return null;
	}

}
