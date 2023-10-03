//LeHoangDe lam ham khoi tao co tham so va khong tham so
class ThiSinh(cccd: String, hoTen: String, toan: Float, ly: Float, hoa: Float, van: Float, anh: Float, khoiThi: String) {
    var cccd: String = ""
    var hoTen: String = ""
    var toan: Float = 0f
    var ly: Float = 0f
    var hoa: Float = 0f
    var van: Float = 0f
    var anh: Float = 0f
    var khoiThi: String = ""

    //Ham khoi tao co tham so
    init {
        this.cccd = cccd
        this.hoTen = hoTen
        this.toan = toan
        this.ly = ly
        this.hoa = hoa
        this.van = van
        this.anh = anh
        this.khoiThi = khoiThi
    }
    
    //Ham khoi tao khong tham so
    constructor() : this("", "", 0f, 0f, 0f, 0f, 0f, "")
}

fun SapXepDS(ds:ArrayList<sinhvien>){
    var temp:sinhvien;
    for(i in  0..ds.size-1){
        for(j in i+1..ds.size-1){
            if(ds[i].SoSanhTen(ds[j])>0){
                temp=ds[i];
                ds[i]=ds[j];
                ds[j]=temp;
            }
        }
    }
}

fun SinhVienTrungTuyen(DS: ArrayList<sinhvien>,diemchuan:Float){
    var boolean=false;
    println("---Danh sách thí sinh trúng tuyển---")
    for (i in 0..DS.size-1){
        if(DS[i].TongDiem()>=diemchuan){
            println(DS[i])
            boolean=true;
        }
    }
    if(!boolean){
        println("--Không có thí sinh trúng tuyển!--")
    }
}

fun main() {
   
}