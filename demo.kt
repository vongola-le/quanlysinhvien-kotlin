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

    //Ham so sanh ho ten
    fun SoSanhTen(HoTen: String): Int {
        val hoTen1 = TachHoTen(this.hoTen)
        val hoTen2 = TachHoTen(HoTen)
    
        val ssTen = hoTen1["Tên"]?.compareTo(hoTen2["Tên"].toString())
        val ssHo = hoTen1["Họ"]?.compareTo(hoTen2["Họ"].toString())
    
        var n : Int = 0
    
        if(ssTen != null) {
            if (ssTen > 0) {
                n = 1
            } else if (ssTen < 0) {
                n = -1
            } else if(ssHo != null){
                if(ssHo > 0){
                    n = 1
                }else if(ssHo < 0){
                    n = -1
                }
            }
        }
    
        return n
    }

    fun Xuat()
    {
        println("Danh sách thông tin thí sinh:")
        {
            println("\nHọ tên: ${it.hoTen}")
            println("Cccd: ${it.cccd}")
            println("Toán: ${it.toan}")
            println("Lý: ${it.ly}")
            println("Hóa: ${it.hoa}")
            println("Văn: ${it.van}")
            println("Anh: ${it.anh}")
            println("Khối thi: ${it.khoithi}")
            println("Tổng điểm: "+TongDiem())
        }
    }

    fun TongDiem()
    {
        var tong:Float?=null
        if(khoithi.uppercase()=="A00")
        {
            tong= toan+ly+hoa
        }
        else if(khoithi.uppercase()=="A01")
        {
            tong= toan+ly+anh
        }
        else if(khoithi.uppercase()=="D01")
        {
            tong=toan+van+anh
        }
        return tong;
    }
}

fun TachHoTen(hoTen: String): Map<String, String>{
    var vt = hoTen.lastIndexOf(" ")
    var chuoiHoTen = mapOf("Họ" to hoTen.substring(0, vt).lowercase(), "Tên" to hoTen.substring(vt+1).lowercase())

    return chuoiHoTen
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