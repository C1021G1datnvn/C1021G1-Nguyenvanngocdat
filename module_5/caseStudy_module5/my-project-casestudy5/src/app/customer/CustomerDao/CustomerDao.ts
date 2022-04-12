import {CustomerInterface} from "../model/CustomerInterface";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn:"root"
})

export class CustomerDao {
  public static customerList: CustomerInterface[] = [
    {
      id: 1,
      name: "Nguyễn Văn Ngọc Đạt",
      birthday: "26-02-2003",
      gender: "Nam",
      card: "0742001017",
      phone: "0845859876",
      email: "dat@gmail.com",
      customerType: "Platinum",
      address: "Da Nang"
    },
    {
      id: 2,
      name: "Đặng Duy Linh",
      birthday: "28-02-1993",
      gender: "Nam",
      card: "0430000233",
      phone: "0123099555",
      email: "ling@gmail.com",
      customerType: "Platinum",
      address: "Da Nang"
    },
    {
      id: 3,
      name: "Nguyễn Anh Hoàng",
      birthday: "26-02-1996",
      gender: "Nam",
      card: "0432019111",
      phone: "0845859876",
      email: "hoang@gmail.com",
      customerType: "Gold",
      address: "Da Nang"
    },
    {
      id: 4,
      name: "Hồ Nhật Hiếu",
      birthday: "26-02-1997",
      gender: "Nam",
      card: "0921441414",
      phone: "0845859876",
      email: "hieu@gmail.com",
      customerType: "Sliver",
      address: "Da Nang"
    },
    {
      id: 5,
      name: "Ngô Duy Bảo",
      birthday: "26-02-1995",
      gender: "Nam",
      card: "0431231232",
      phone: "0845859876",
      email: "bao@gmail.com",
      customerType: "Diamond",
      address: "Da Nang"
    },
    {
      id: 6,
      name: "Phạm Duy Thuận",
      birthday: "09-09-2003",
      gender: "Nam",
      card: "0929911144",
      phone: "0845859876",
      email: "thuan@gmail.com",
      customerType: "Member",
      address: "Da Nang"
    }
  ];

  getInformation(id: number){
    for (let i of CustomerDao.customerList) {
      if (i.id === id) {
        return i;
      }
    }
  }
  deleteCustomer(id:number) {
    CustomerDao.customerList.splice(id-1, 1)
  }

}

