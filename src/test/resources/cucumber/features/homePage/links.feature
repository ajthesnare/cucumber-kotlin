Feature: Home Page - Links
  Validate the links on the Home page

  Scenario: Links display on the home page
    Given I am on the "Home" page
    Then the following links should display:
      | href                   | text                          |
      | /abtest                | A/B Testing                   |
      | /add_remove_elements/  | Add/Remove Elements           |
      | /basic_auth            | Basic Auth                    |
      | /broken_images         | Broken Images                 |
      | /challenging_dom       | Challenging DOM               |
      | /checkboxes            | Checkboxes                    |
      | /context_menu          | Context Menu                  |
      | /digest_auth           | Digest Authentication         |
      | /disappearing_elements | Disappearing Elements         |
      | /drag_and_drop         | Drag and Drop                 |
      | /dropdown              | Dropdown                      |
      | /dynamic_content       | Dynamic Content               |
      | /dynamic_controls      | Dynamic Controls              |
      | /dynamic_loading       | Dynamic Loading               |
      | /entry_ad              | Entry Ad                      |
      | /exit_intent           | Exit Intent                   |
      | /download              | File Download                 |
      | /upload                | File Upload                   |
      | /floating_menu         | Floating Menu                 |
      | /forgot_password       | Forgot Password               |
      | /login                 | Form Authentication           |
      | /frames                | Frames                        |
      | /geolocation           | Geolocation                   |
      | /horizontal_slider     | Horizontal Slider             |
      | /hovers                | Hovers                        |
      | /infinite_scroll       | Infinite Scroll               |
      | /inputs                | Inputs                        |
      | /jqueryui/menu         | JQuery UI Menus               |
      | /javascript_alerts     | JavaScript Alerts             |
      | /javascript_error      | JavaScript onload event error |
      | /key_presses           | Key Presses                   |
      | /large                 | Large & Deep DOM              |
      | /windows               | Multiple Windows              |
      | /nested_frames         | Nested Frames                 |
      | /notification_message  | Notification Messages         |
      | /redirector            | Redirect Link                 |
      | /download_secure       | Secure File Download          |
      | /shifting_content      | Shifting Content              |
      | /slow                  | Slow Resources                |
      | /tables                | Sortable Data Tables          |
      | /status_codes          | Status Codes                  |
      | /typos                 | Typos                         |
      | /tinymce               | WYSIWYG Editor                |
