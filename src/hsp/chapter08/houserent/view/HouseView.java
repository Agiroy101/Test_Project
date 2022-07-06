package hsp.chapter08.houserent.view;

import hsp.chapter08.houserent.domian.House;
import hsp.chapter08.houserent.service.HouseService;
import hsp.chapter08.houserent.utils.Utility;

public class HouseView {

    private boolean flag = true;
    private HouseService hs = new HouseService(6);


    public void mainMenu() {
        do {
            System.out.println("------------房屋出租系统------------");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删 除 房 屋");
            System.out.println("\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退      出");
            System.out.println("请选择（1-6）");


            char c = Utility.readChar();
            switch (c) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    search();
                    break;
                case '3':
                    delete();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    list();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (flag);
    }

    public void addHouse() {
        System.out.println("------------添加房屋------------");

        System.out.print("姓名：");
        String name = Utility.readString(5);

        System.out.println("电话：");
        String phone = Utility.readString(13);

        System.out.println("地址：");
        String address = Utility.readString(13);

        System.out.println("月租：");
        int rent = Utility.readInt();

        System.out.println("状态（未出租/已出租）：");
        String status = Utility.readString(5);

        House house = new House(0, name, phone, address, rent, status);
        if (hs.add(house)) {
            System.out.println("------------添加成功------------");
        } else {
            System.out.println("------------添加失败------------");
        }


    }

    public void list() {
        House[] list = hs.list();
        System.out.println("------------房屋列表------------");
        System.out.println("编号\t\t姓名\t\t电话\t\t地址\t\t月租\t\t状态");
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                continue;
            }
            System.out.println(list[i]);
        }
        System.out.println("------------房屋显示完毕------------");
    }

    public void search() {
        System.out.println("请输入要查找的房屋编号");
        int id = Utility.readInt();
        House search = hs.search(id);
        if (search != null) {
            System.out.println("编号\t\t姓名\t\t电话\t\t地址\t\t月租\t\t状态");
            System.out.println(search);
            System.out.println("------------房屋显示完毕------------");
        } else {
            System.out.println("没有找到编号为" + id + "的房屋");
        }
    }

    public void delete(){
        System.out.println("请输入要删除的房屋编号");
        int id = Utility.readInt();
        if(id == -1){
            System.out.println("---------放弃删除房屋信息----------");
            return;
        }
        System.out.println("请确认是否删除（Y/N）,请小心选择：");
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            boolean delete = hs.delete(id);
            if(delete){
                System.out.println("-----------删除成功------------");
            }else {
                System.out.println("-----------删除失败------------");
            }

        }else {
            System.out.println("-------------放弃删除房屋信息-------------");
        }
    }

    public void update(){
        System.out.println("请输入要修改的房屋编号");
        int id = Utility.readInt();
        if(id == -1){
            System.out.println("---------放弃修改房屋信息----------");
            return;
        }
        House search = hs.search(id);
        if(search == null){
            System.out.println("------------房屋信息不存在------------");
            return;
        }
        System.out.print("姓名（"+search.getName()+"）:");
        String name = Utility.readString(8,"");
        if(!name.equals(""))
            search.setName(name);

        System.out.println("电话（" + search.getPhone() + "）：");
        String phone = Utility.readString(13,"");
        if(!phone.equals(""))
            search.setPhone(phone);

        System.out.println("地址（" + search.getAddress() + "）：");
        String address = Utility.readString(13,"");
        if(!address.equals(""))
            search.setAddress(address);

        System.out.println("租金（" + search.getRent() + "）：");
        int rent = Utility.readInt(-1);
        if(rent != -1)
            search.setRent(rent);

        System.out.println("状态（" + search.getStatue() + "）");
        String statue = Utility.readString(5,"");
        if(!statue.equals(""))
            search.setStatue(statue);
        System.out.println("-----------修改房屋信息成功------------");

    }

    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            flag = false;
        }
    }

}
