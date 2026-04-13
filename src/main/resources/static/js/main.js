// Mobile navigation toggle
document.addEventListener('DOMContentLoaded', function () {
  var toggle = document.getElementById('navToggle');
  var menu   = document.getElementById('navMenu');

  if (toggle && menu) {
    toggle.addEventListener('click', function () {
      menu.classList.toggle('open');
    });

    // Close menu when a nav link is clicked
    menu.querySelectorAll('a').forEach(function (link) {
      link.addEventListener('click', function () {
        menu.classList.remove('open');
      });
    });
  }

  // Close mobile menu on outside click
  document.addEventListener('click', function (e) {
    if (menu && toggle && !menu.contains(e.target) && !toggle.contains(e.target)) {
      menu.classList.remove('open');
    }
  });

  // ── Services page: Tab switching ──────────────────────────────────────────
  var tabsContainer = document.querySelector('.tabs');
  if (tabsContainer) {
    // Kích hoạt tab đầu tiên khi load (phòng trường hợp CSS chưa xử lý)
    var firstBtn = tabsContainer.querySelector('.tab-btn.active');
    if (firstBtn) {
      var firstTabId = firstBtn.dataset.tabId;
      activateTab(firstTabId, firstBtn);
    }

    // Event delegation: lắng nghe click trên toàn bộ .tabs
    tabsContainer.addEventListener('click', function (e) {
      var btn = e.target.closest('.tab-btn');
      if (!btn) return;
      var tabId = btn.dataset.tabId;
      activateTab(tabId, btn);
    });
  }

  function activateTab(tabId, activeBtn) {
    // Ẩn tất cả tab content
    document.querySelectorAll('.service-tab-content').forEach(function (el) {
      el.classList.remove('active');
    });
    // Bỏ active tất cả tab button
    document.querySelectorAll('.tab-btn').forEach(function (el) {
      el.classList.remove('active');
    });
    // Hiện tab được chọn
    var target = document.getElementById('tab-' + tabId);
    if (target) target.classList.add('active');
    if (activeBtn) activeBtn.classList.add('active');
  }
});
