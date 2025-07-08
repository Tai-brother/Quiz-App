   # <span style="color:#1976d2;">🎓Quiz App - Ứng dụng trắc nghiệm </span>

## <span style="color:#1976d2;">📚 Mục lục</span>
1. [<span style="color:#1976d2;">Tên dự án & Chủ đề</span>](#1-tên-dự-án--chủ-đề)
2. [<span style="color:#1976d2;">Lý do lựa chọn dự án</span>](#2-lý-do-lựa-chọn-dự-án)
3. [<span style="color:#1976d2;">Công nghệ sử dụng</span>](#3-công-nghệ-sử-dụng)
4. [<span style="color:#1976d2;">Các tính năng chính</span>](#4-các-tính-năng-chính)
5. [<span style="color:#1976d2;">Hướng dẫn sử dụng</span>](#5-hướng-dẫn-sử-dụng)
6. [<span style="color:#1976d2;">Nguyên tắc làm việc</span>](#6-nguyên-tắc-làm-việc)
7. [<span style="color:#1976d2;">Tính năng phát triển thêm</span>](#7-tính-năng-phát-triển-thêm)
8. [<span style="color:#1976d2;">Giấy phép & Liên hệ</span>](#8-giấy-phép--liên-hệ)

---

## <span id="1-tên-dự-án--chủ-đề" style="color:#1976d2;">🚀 1. Tên dự án & Chủ đề</span>

### 📌 Ý nghĩa tên Quiz App

- **Quiz App** là ứng dụng trắc nghiệm đa chủ đề, hướng tới sự đơn giản, dễ tiếp cận, phù hợp cho mọi đối tượng muốn kiểm tra, rèn luyện kiến thức.
- "Quiz" là cốt lõi: kiểm tra kiến thức, học mà chơi, chơi mà học.
- "App" - nền tảng di động, luôn sẵn sàng mọi lúc mọi nơi.

---

## <span id="2-lý-do-lựa-chọn-dự-án" style="color:#1976d2;">🔥 2. Lý do lựa chọn dự án</span>

- Nhu cầu luyện tập trắc nghiệm, kiểm tra nhanh ngày càng phổ biến trong học tập, tuyển dụng, giải trí.
- Các app quiz giúp tăng động lực học, tạo môi trường thi đua lành mạnh.
- Dễ mở rộng cho nhiều chủ đề, phù hợp học sinh, sinh viên, giáo viên, người đi làm.
- Đáp ứng xu hướng học tập chủ động, cá nhân hóa, gamification.

---

## <span id="3-công-nghệ-sử-dụng" style="color:#1976d2;">🛠️ 3. Công nghệ sử dụng</span>
✨ 

![Java](https://img.shields.io/badge/-JAVA-000?style=for-the-badge&logo=java&logoColor=white)
![Android](https://img.shields.io/badge/-ANDROID-000?style=for-the-badge&logo=android&logoColor=white)
![MVP](https://img.shields.io/badge/-MVP-000?style=for-the-badge&logoColor=white)
![Material Design](https://img.shields.io/badge/-MATERIAL%20DESIGN-000?style=for-the-badge&logo=materialdesign&logoColor=white)
![JUnit](https://img.shields.io/badge/-JUNIT-000?style=for-the-badge&logo=junit5&logoColor=white)

- **Ngôn ngữ:** Java (Android), một số màn splash dùng Kotlin
- **Kiến trúc:** MVP (Model-View-Presenter)
- **UI:** AndroidX, Material Design, CardView, ConstraintLayout
- **Lưu trữ:** SharedPreferences
- **Kiểm thử:** JUnit, AndroidJUnit4
- **Thư viện:** Confetti, FancyGifDialog, Konfetti

---

## <span id="4-các-tính-năng-chính" style="color:#1976d2;">🎮 4. Các tính năng chính</span>

- **Đăng nhập nhanh:** Nhập tên người dùng, không cần tài khoản phức tạp.
- **Chọn chủ đề:** Toán, Địa lý, Văn học (dễ mở rộng thêm chủ đề mới).
- **Câu hỏi ngẫu nhiên:** Mỗi lần chơi là một trải nghiệm mới.
- **Tính điểm thông minh:** Đúng +5, sai -2, lưu lịch sử điểm.
- **Xem lịch sử:** Thống kê số lần chơi, tổng điểm, chi tiết từng lần.
- **Giao diện đẹp, dễ dùng:** Hỗ trợ cả chế độ sáng/tối.
- **Màn hình kết quả sinh động:** Hiệu ứng chúc mừng, tổng kết điểm.
- **Trang About:** Giới thiệu app, liên kết mạng xã hội, logo đẹp.

---

## <span id="5-hướng-dẫn-sử-dụng" style="color:#1976d2;">📲 5. Hướng dẫn sử dụng</span>

### 1. **Yêu cầu**
- Android Studio (khuyến nghị bản mới nhất)
- JDK 8+
- Android SDK 21+

### 2. **Clone project**
```bash
git clone <repo-url>
```

### 3. **Mở bằng Android Studio**
- File > Open > trỏ tới thư mục `Quiz-App`

### 4. **Sync Gradle**
- Android Studio sẽ tự động sync, nếu không:  
  File > Sync Project with Gradle Files

### 5. **Build & Run**
- Chọn thiết bị ảo (AVD) hoặc điện thoại thật
- Nhấn Run (Shift+F10)

### 6. **Sử dụng app**
1. Mở app, nhập tên người dùng
2. Chọn chủ đề quiz (Toán, Địa lý, Văn học)
3. Trả lời 10 câu hỏi ngẫu nhiên
4. Xem kết quả, điểm số, lịch sử
5. Vào mục About để xem thông tin app, liên kết mạng xã hội

---

## <span id="6-nguyên-tắc-làm-việc" style="color:#1976d2;">📏 6. Nguyên tắc làm việc</span>

### 🟢 **Commit Convention (Quy ước commit):**
```
feat:      thêm một tính năng mới
fix:       sửa lỗi
refactor:  cải tiến code không thay đổi logic
docs:      cập nhật tài liệu
chore:     thay đổi nhỏ, không ảnh hưởng logic
style:     thay đổi về giao diện, UI
perf:      tối ưu hiệu năng
```

### 🔵 **Branch Naming:**
```
feature/:  phát triển tính năng mới
bugfix/:   sửa lỗi
```
Ví dụ: `feature/add-history-screen`, `bugfix/fix-score-bug`

### 🖼️ **Code Style**
- Theo chuẩn Java/Android, format tự động bằng Android Studio
- Tên biến, hàm rõ nghĩa, comment khi cần thiết

---

## <span id="7-tính-năng-phát-triển-thêm" style="color:#1976d2;">🌱 7. Tính năng phát triển thêm (dự kiến)</span>

1. **Chế độ thi đấu nhóm:** Chia người chơi thành đội, tính điểm nhóm, bảng xếp hạng nhóm.
2. **Đồng bộ dữ liệu online:** Lưu lịch sử, điểm số lên cloud, đăng nhập Google/Facebook.
3. **Tích hợp AI tạo câu hỏi:** Đề xuất câu hỏi dựa trên lịch sử làm bài.
4. **Hỗ trợ đa ngôn ngữ:** Cho phép chọn ngôn ngữ giao diện và câu hỏi.
5. **Chế độ thử thách thời gian thực:** Nhiều người chơi cùng lúc, xếp hạng trực tiếp.
6. **Thêm chủ đề, dạng câu hỏi mới:** Tự tạo quiz, import từ file, ...

---

## <span id="8-giấy-phép--liên-hệ" style="color:#1976d2;">📄 8. Giấy phép & Liên hệ</span>

- Icon: [Flaticon](https://www.flaticon.com/free-icon/quiz_3062634)
- Thư viện: MIT/Apache 2.0 (xem chi tiết trong từng dependency)
- Mọi thắc mắc, đóng góp, vui lòng liên hệ qua trang About của app!

---

> <span style="color:#1976d2; font-weight:bold;">Quiz App - Học vui, chơi chất, thử thách trí tuệ!</span>
# Quiz-App
